USE covid_db;
DROP PROCEDURE IF EXISTS UpdateCovidStats;
DELIMITER $$
CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_new_confirmed INT,
    IN p_new_deaths INT,
    IN p_new_recoveries INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    START TRANSACTION;
    INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries)
    VALUES (p_country, p_date, p_new_confirmed, p_new_deaths, p_new_recoveries)
    ON DUPLICATE KEY UPDATE
        confirmed_cases = confirmed_cases + p_new_confirmed,
        deaths = deaths + p_new_deaths,
        recoveries = recoveries + p_new_recoveries;
    COMMIT;
END$$
DELIMITER ;
CALL UpdateCovidStats('India', '2023-04-01', 1000, 50, 800);
SELECT * FROM covid_cases WHERE country = 'India' AND report_date >= '2023-04-01';
