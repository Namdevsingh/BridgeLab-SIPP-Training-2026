-- ============================================================
-- Challenge 5: Alter Table (DDL)
-- ============================================================
-- Task: Add a vaccination_rate column (FLOAT) to the
--       covid_cases table for tracking vaccination percentages.
-- ============================================================

USE covid_db;

-- Step 1: View the current table structure
DESCRIBE covid_cases;

-- Step 2: Add the vaccination_rate column with FLOAT data type
ALTER TABLE covid_cases
ADD COLUMN vaccination_rate FLOAT DEFAULT NULL
COMMENT 'Percentage of population vaccinated';

-- Step 3: Verify the new column has been added
DESCRIBE covid_cases;

-- Step 4: (Optional) Update sample vaccination data
UPDATE covid_cases
SET vaccination_rate = 72.5
WHERE state = 'India' AND date = '2020-03-15';

-- Step 5: View the data with the new column
SELECT * FROM covid_cases;

