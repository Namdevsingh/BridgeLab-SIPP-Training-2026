-- ============================================================
-- Task 4: Delete Incorrect Records
-- ============================================================
-- Demonstrates data cleansing by removing:
--   1. Records with incorrect country names (e.g., 'IN' instead of 'India')
--   2. Duplicate records for the same country and date
-- ============================================================

USE covid_db;

-- ---------------------------------------------------
-- First, let's simulate inserting some incorrect and
-- duplicate records for demonstration purposes.
-- ---------------------------------------------------

-- Insert a record with wrong country name: 'IN' instead of 'India'
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('IN', '2023-01-01', 44678900, 530800, 44123000, 1428627663);

-- Insert a duplicate record for India on 2023-01-01
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('India', '2023-01-01', 44678900, 530800, 44123000, 1428627663);

-- Insert a record with wrong country name: 'United States' vs 'USA'
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('United States', '2023-01-01', 102000000, 1112000, 100500000, 339996563);

-- ---------------------------------------------------
-- View all records including the bad ones
-- ---------------------------------------------------
SELECT * FROM covid_cases ORDER BY country, report_date;

-- ---------------------------------------------------
-- Delete 1: Remove records where country is 'IN' (invalid)
-- ---------------------------------------------------
DELETE FROM covid_cases
WHERE country = 'IN';

-- ---------------------------------------------------
-- Delete 2: Remove duplicate records
-- Keep only one record per (country, report_date) combination.
-- Using a subquery to identify and remove duplicates.
-- ---------------------------------------------------

-- Step 1: Identify duplicates (same country and date, higher case_id)
SELECT cc.case_id, cc.country, cc.report_date
FROM covid_cases cc
JOIN (
    SELECT country, report_date, MIN(case_id) AS min_id
    FROM covid_cases
    GROUP BY country, report_date
    HAVING COUNT(*) > 1
) dup ON cc.country = dup.country AND cc.report_date = dup.report_date
WHERE cc.case_id > dup.min_id;

-- Step 2: Delete the duplicate records (keeping the earliest case_id)
DELETE cc
FROM covid_cases cc
JOIN (
    SELECT country, report_date, MIN(case_id) AS min_id
    FROM covid_cases
    GROUP BY country, report_date
    HAVING COUNT(*) > 1
) dup ON cc.country = dup.country AND cc.report_date = dup.report_date
WHERE cc.case_id > dup.min_id;

-- Alternatively, a simpler approach using a subquery:
-- DELETE FROM covid_cases
-- WHERE case_id NOT IN (
--     SELECT MIN(case_id)
--     FROM covid_cases
--     GROUP BY country, report_date
-- );

-- ---------------------------------------------------
-- Delete 3: Remove records with incorrect country names
-- (e.g., 'United States' should be 'USA')
-- ---------------------------------------------------
DELETE FROM covid_cases
WHERE country = 'United States';

-- ---------------------------------------------------
-- Verify the data after cleanup
-- ---------------------------------------------------
SELECT * FROM covid_cases ORDER BY country, report_date;

