-- ============================================================
-- Challenge 1: Create COVID Database Schema (DDL)
-- ============================================================
-- Task A: Create a database named covid_db and select it for use.
-- Task B: Create a table named covid_cases based on the CSV mapping.
-- The table includes:
--   - An id column as AUTO_INCREMENT PRIMARY KEY
--   - date (DATE)
--   - time (TIME)
--   - state (VARCHAR)
--   - confirmed_indian_national (INT)
--   - confirmed_foreign_national (INT)
--   - recoveries (INT) - mapped from CSV "Cured"
--   - deaths (INT)
--   - confirmed_cases (INT) - mapped from CSV "Confirmed"
-- ============================================================

-- Task A: Create the database
CREATE DATABASE IF NOT EXISTS covid_db;

-- Select the database for use
USE covid_db;

-- Task B: Create the covid_cases table
CREATE TABLE IF NOT EXISTS covid_cases (
    id                         INT AUTO_INCREMENT PRIMARY KEY,
    date                       DATE NOT NULL,
    time                       TIME NOT NULL,
    state                      VARCHAR(100) NOT NULL,
    confirmed_indian_national  INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    recoveries                 INT DEFAULT 0,
    deaths                     INT DEFAULT 0,
    confirmed_cases            INT DEFAULT 0
);

-- Display table structure to verify
DESCRIBE covid_cases;

