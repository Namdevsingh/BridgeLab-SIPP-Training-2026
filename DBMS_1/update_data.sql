-- ============================================================
-- Task 3: Update Case Information
-- ============================================================
-- Demonstrates updating COVID-19 statistics when revised data
-- is provided by health authorities.
-- ============================================================

USE covid_db;

-- ---------------------------------------------------
-- Scenario: India's confirmed cases on 2023-01-15
-- are revised upward by the health department.
-- ---------------------------------------------------

-- Step 1: View the current (old) record for India on 2023-01-15
SELECT * FROM covid_cases
WHERE country = 'India' AND report_date = '2023-01-15';

-- Step 2: Update the confirmed cases and deaths with revised data
UPDATE covid_cases
SET confirmed_cases = 44722300,   -- Revised from 44712300
    deaths = 531250               -- Revised from 531100
WHERE country = 'India'
  AND report_date = '2023-01-15';

-- Step 3: Verify the updated record
SELECT * FROM covid_cases
WHERE country = 'India' AND report_date = '2023-01-15';

-- ---------------------------------------------------
-- Scenario: USA's recoveries on 2023-02-01 are updated
-- ---------------------------------------------------
UPDATE covid_cases
SET recoveries = 101350000        -- Revised figure
WHERE country = 'USA'
  AND report_date = '2023-02-01';

-- Verify the update
SELECT * FROM covid_cases
WHERE country = 'USA' AND report_date = '2023-02-01';

-- ---------------------------------------------------
-- Display all records after updates
-- ---------------------------------------------------
SELECT * FROM covid_cases ORDER BY country, report_date;

