USE covid_db;

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE,
    continent      VARCHAR(50),
    population     BIGINT,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT IGNORE INTO countries (country_code, country_name, continent, population) VALUES
    ('IND', 'India', 'Asia', 1428627663),
    ('USA', 'United States of America', 'North America', 339996563),
    ('GBR', 'United Kingdom', 'Europe', 67736802);

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    id                         INT AUTO_INCREMENT PRIMARY KEY,
    country_code               CHAR(3) NOT NULL,
    report_date                DATE NOT NULL,
    time                       TIME,
    confirmed_indian_national  INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    recoveries                 INT DEFAULT 0,
    deaths                     INT DEFAULT 0,
    confirmed_cases            INT NOT NULL DEFAULT 0,
    last_updated               TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_country
        FOREIGN KEY (country_code)
        REFERENCES countries(country_code)
        ON DELETE CASCADE,
    UNIQUE KEY unique_country_date (country_code, report_date)
);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths)
VALUES ('IND', '2020-03-15', '10:00:00', 100, 2);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('USA', '2020-03-15', '10:00:00', 500, 10, 200);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths)
VALUES ('GBR', '2020-03-15', '10:00:00', 300, 5);

UPDATE covid_cases
SET confirmed_cases = 120
WHERE country_code = 'IND' AND report_date = '2020-03-15';

SELECT
    id,
    country_code,
    report_date,
    confirmed_cases,
    deaths,
    recoveries,
    last_updated
FROM covid_cases;

DESCRIBE covid_cases;

