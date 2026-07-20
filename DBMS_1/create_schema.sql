CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

CREATE TABLE covid_cases (
    case_id       INT AUTO_INCREMENT PRIMARY KEY,
    country       VARCHAR(100) NOT NULL,
    report_date   DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths        INT DEFAULT 0,
    recoveries    INT DEFAULT 0,
    population    BIGINT DEFAULT NULL,
    UNIQUE KEY unique_country_date (country, report_date)
);

CREATE TABLE covid_deaths (
    death_id      INT AUTO_INCREMENT PRIMARY KEY,
    country       VARCHAR(100) NOT NULL,
    report_date   DATE NOT NULL,
    total_deaths  INT DEFAULT 0,
    new_deaths    INT DEFAULT 0,
    population    BIGINT DEFAULT NULL,
    UNIQUE KEY unique_death_country_date (country, report_date)
);

CREATE TABLE covid_vaccines (
    vaccine_id        INT AUTO_INCREMENT PRIMARY KEY,
    country           VARCHAR(100) NOT NULL,
    report_date       DATE NOT NULL,
    total_vaccinations BIGINT DEFAULT 0,
    people_vaccinated  BIGINT DEFAULT 0,
    people_fully_vaccinated BIGINT DEFAULT 0,
    population        BIGINT DEFAULT NULL,
    UNIQUE KEY unique_vaccine_country_date (country, report_date)
);

SHOW TABLES;

