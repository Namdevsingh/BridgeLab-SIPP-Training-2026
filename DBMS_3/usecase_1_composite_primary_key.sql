CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    id                         INT AUTO_INCREMENT,
    country                    VARCHAR(100) NOT NULL,
    report_date                DATE NOT NULL,
    time                       TIME,
    confirmed_indian_national  INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    recoveries                 INT DEFAULT 0,
    deaths                     INT DEFAULT 0,
    confirmed_cases            INT DEFAULT 0,
    population                 BIGINT DEFAULT NULL,
    PRIMARY KEY (country, report_date, id)
);

DESCRIBE covid_cases;

INSERT INTO covid_cases (country, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('India', '2020-03-15', '10:00:00', 100, 2, 50);

INSERT INTO covid_cases (country, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('India', '2020-03-16', '10:00:00', 150, 3, 60);

INSERT INTO covid_cases (country, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('USA', '2020-03-15', '10:00:00', 500, 10, 200);

SELECT * FROM covid_cases;

