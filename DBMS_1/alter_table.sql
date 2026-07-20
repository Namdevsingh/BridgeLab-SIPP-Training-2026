-- ============================================================
-- Task 5: Alter Table to Add Vaccination Information
-- ============================================================
-- Extends the database schema by adding a vaccination_rate
-- column to the covid_cases table.
-- ============================================================

USE covid_db;

-- ---------------------------------------------------
-- Step 1: Describe the current structure of covid_cases
-- ---------------------------------------------------
DESCRIBE covid_cases;

-- ---------------------------------------------------
-- Step 2: Add a new column 'vaccination_rate' to store
--         the percentage of vaccinated population.
--         Data type: DECIMAL(5,2) allows values like 99.99%
-- ---------------------------------------------------
ALTER TABLE covid_cases
ADD COLUMN vaccination_rate DECIMAL(5,2) DEFAULT NULL
COMMENT 'Percentage of population vaccinated';

-- ---------------------------------------------------
-- Step 3: Verify the new column has been added
-- ---------------------------------------------------
DESCRIBE covid_cases;

-- ---------------------------------------------------
-- Step 4: Update vaccination_rate with sample data
-- ---------------------------------------------------
UPDATE covid_cases
SET vaccination_rate = 72.50
WHERE country = 'India';

UPDATE covid_cases
SET vaccination_rate = 81.30
WHERE country = 'USA';

UPDATE covid_cases
SET vaccination_rate = 79.10
WHERE country = 'UK';

-- ---------------------------------------------------
-- Step 5: View the data including the new column
-- ---------------------------------------------------
SELECT country, report_date, confirmed_cases, vaccination_rate
FROM covid_cases
ORDER BY country, report_date;

-- ---------------------------------------------------
-- Bonus: Add a CHECK constraint to ensure valid range
-- ---------------------------------------------------
ALTER TABLE covid_cases
ADD CONSTRAINT chk_vaccination_rate
CHECK (vaccination_rate >= 0 AND vaccination_rate <= 100);

