-- ============================================================
-- Task 1: Create COVID Database Schema
-- ============================================================
-- This script creates the COVID-19 database and three tables:
--   covid_cases  - Stores confirmed cases, deaths, recoveries by country/date
--   covid_deaths - Stores death-related statistics by country/date
--   covid_vaccines - Stores vaccination data by country/date
-- ============================================================

-- Create the database
CREATE DATABASE IF NOT EXISTS covid_db;

-- Use the database
USE covid_db;

-- ---------------------------------------------------
-- Table: covid_cases
-- Stores daily confirmed COVID-19 case information
-- ---------------------------------------------------
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

-- ---------------------------------------------------
-- Table: covid_deaths
-- Stores detailed COVID-19 death statistics
-- ---------------------------------------------------
CREATE TABLE covid_deaths (
    death_id      INT AUTO_INCREMENT PRIMARY KEY,
    country       VARCHAR(100) NOT NULL,
    report_date   DATE NOT NULL,
    total_deaths  INT DEFAULT 0,
    new_deaths    INT DEFAULT 0,
    population    BIGINT DEFAULT NULL,
    UNIQUE KEY unique_death_country_date (country, report_date)
);

-- ---------------------------------------------------
-- Table: covid_vaccines
-- Stores COVID-19 vaccination administration data
-- ---------------------------------------------------
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

-- Display all tables in the database
SHOW TABLES;

