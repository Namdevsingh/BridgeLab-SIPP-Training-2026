USE covid_db;
DROP TABLE IF EXISTS covid_cases_audit;
DROP TRIGGER IF EXISTS trg_covid_cases_before_update;
CREATE TABLE covid_cases_audit (
    audit_id      INT AUTO_INCREMENT PRIMARY KEY,
    case_id       INT NOT NULL,
    country       VARCHAR(100) NOT NULL,
    report_date   DATE NOT NULL,
    old_confirmed INT,
    new_confirmed INT,
    old_deaths    INT,
    new_deaths    INT,
    old_recoveries INT,
    new_recoveries INT,
    changed_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    action_type   VARCHAR(20) DEFAULT 'UPDATE'
);
DELIMITER $$
CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        case_id, country, report_date,
        old_confirmed, new_confirmed,
        old_deaths, new_deaths,
        old_recoveries, new_recoveries,
        changed_at, action_type
    )
    VALUES (
        OLD.case_id, OLD.country, OLD.report_date,
        OLD.confirmed_cases, NEW.confirmed_cases,
        OLD.deaths, NEW.deaths,
        OLD.recoveries, NEW.recoveries,
        NOW(), 'UPDATE'
    );
END$$
DELIMITER ;
UPDATE covid_cases
SET confirmed_cases = confirmed_cases + 500,
    deaths = deaths + 10,
    recoveries = recoveries + 400
WHERE country = 'India' AND report_date = '2023-03-01';
SELECT * FROM covid_cases_audit;
SELECT * FROM covid_cases WHERE country = 'India' ORDER BY report_date;
