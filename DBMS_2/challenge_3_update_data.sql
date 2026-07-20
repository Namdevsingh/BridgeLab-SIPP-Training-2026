-- ============================================================
-- Challenge 3: Update Case Information (DML)
-- ============================================================
-- Task: Update the confirmed cases to 120 for the record
--       where state = 'India' AND date = '2020-03-15'.
-- ============================================================

USE covid_db;

-- Step 1: View the current record before update
SELECT * FROM covid_cases
WHERE state = 'India' AND date = '2020-03-15';

-- Step 2: Update confirmed_cases to 120
UPDATE covid_cases
SET confirmed_cases = 120
WHERE state = 'India'
  AND date = '2020-03-15';

-- Step 3: Verify the update
SELECT * FROM covid_cases
WHERE state = 'India' AND date = '2020-03-15';

-- View all records after update
SELECT * FROM covid_cases;

