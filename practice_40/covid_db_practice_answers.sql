-- Challenge 1: Create COVID Database Schema (DDL)
CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

CREATE TABLE IF NOT EXISTS covid_cases (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    state VARCHAR(100) NOT NULL,
    confirmed_indian_national BIGINT DEFAULT 0,
    confirmed_foreign_national BIGINT DEFAULT 0,
    recoveries BIGINT DEFAULT 0,
    deaths BIGINT DEFAULT 0,
    confirmed_cases BIGINT DEFAULT 0,
    population BIGINT DEFAULT 0,
    vaccination_rate FLOAT DEFAULT NULL,
    PRIMARY KEY (id)
);

-- Challenge 2: Insert Initial COVID Data (DML)
-- India on 2020-03-15 at 10 AM, 50 recoveries, 2 deaths, 100 confirmed cases
INSERT INTO covid_cases (
    date, time, state,
    recoveries, deaths, confirmed_cases,
    confirmed_indian_national, confirmed_foreign_national,
    population
) VALUES (
    '2020-03-15', '10:00:00', 'India',
    50, 2, 100,
    100, 0,
    1380004385
);

-- Challenge 3: Update Case Information (DML)
-- Update confirmed cases to 120 for India, 2020-03-15
UPDATE covid_cases
SET confirmed_cases = 120,
    confirmed_indian_national = 120
WHERE state = 'India' AND date = '2020-03-15';

-- Challenge 4: Delete Incorrect Records (DML)
-- Delete rogue entry where state = 'IN'
DELETE FROM covid_cases
WHERE state = 'IN';

-- Challenge 5: Alter Table (DDL)
-- Add vaccination_rate column (if not already present)
ALTER TABLE covid_cases
ADD COLUMN IF NOT EXISTS vaccination_rate FLOAT;

