-- ============================================================
-- Challenge 2: Insert Initial COVID Data (DML)
-- ============================================================
-- Task: Insert a new record for 'India' on '2020-03-15' at '10 AM',
--       with 50 recoveries, 2 deaths, and 100 confirmed cases.
-- ============================================================

USE covid_db;

-- Insert the record for India
INSERT INTO covid_cases (date, time, state, confirmed_indian_national, confirmed_foreign_national, recoveries, deaths, confirmed_cases)
VALUES ('2020-03-15', '10:00:00', 'India', 90, 10, 50, 2, 100);

-- View the inserted record
SELECT * FROM covid_cases;

