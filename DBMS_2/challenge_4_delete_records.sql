-- ============================================================
-- Challenge 4: Delete Incorrect Records (DML)
-- ============================================================
-- Task: A rogue entry was added where the state is listed as
--       'IN' instead of 'India'. Write a query to delete it.
-- ============================================================

USE covid_db;

-- Step 1: Insert a rogue record with state = 'IN' (incorrect)
INSERT INTO covid_cases (date, time, state, confirmed_indian_national, confirmed_foreign_national, recoveries, deaths, confirmed_cases)
VALUES ('2020-03-15', '10:00:00', 'IN', 90, 10, 50, 2, 100);

-- Step 2: View all records including the bad one
SELECT * FROM covid_cases;

-- Step 3: Delete the record where state = 'IN'
DELETE FROM covid_cases
WHERE state = 'IN';

-- Step 4: Verify the incorrect record has been removed
SELECT * FROM covid_cases;

