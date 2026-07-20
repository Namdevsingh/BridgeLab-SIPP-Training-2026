USE covid_db;

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE,
    continent      VARCHAR(50),
    population     BIGINT,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO countries (country_code, country_name, continent, population) VALUES
    ('IND', 'India', 'Asia', 1428627663),
    ('USA', 'United States of America', 'North America', 339996563),
    ('GBR', 'United Kingdom', 'Europe', 67736802),
    ('CAN', 'Canada', 'North America', 38781289),
    ('AUS', 'Australia', 'Oceania', 26141369);

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
    confirmed_cases            INT DEFAULT 0,
    UNIQUE KEY unique_country_date (country_code, report_date),
    CONSTRAINT fk_country
        FOREIGN KEY (country_code)
        REFERENCES countries(country_code)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('IND', '2020-03-15', '10:00:00', 100, 2, 50);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('USA', '2020-03-15', '10:00:00', 500, 10, 200);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('GBR', '2020-03-15', '10:00:00', 300, 5, 100);

SELECT
    cc.id,
    cc.country_code,
    cnt.country_name,
    cnt.continent,
    cc.report_date,
    cc.confirmed_cases,
    cc.deaths,
    cc.recoveries
FROM covid_cases cc
JOIN countries cnt ON cc.country_code = cnt.country_code
ORDER BY cc.report_date, cnt.country_name;

