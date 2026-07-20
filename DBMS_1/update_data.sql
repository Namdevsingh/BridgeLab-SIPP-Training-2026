USE covid_db;

SELECT * FROM covid_cases
WHERE country = 'India' AND report_date = '2023-01-15';

UPDATE covid_cases
SET confirmed_cases = 44722300,
    deaths = 531250
WHERE country = 'India'
  AND report_date = '2023-01-15';

SELECT * FROM covid_cases
WHERE country = 'India' AND report_date = '2023-01-15';

UPDATE covid_cases
SET recoveries = 101350000
WHERE country = 'USA'
  AND report_date = '2023-02-01';

SELECT * FROM covid_cases
WHERE country = 'USA' AND report_date = '2023-02-01';

SELECT * FROM covid_cases ORDER BY country, report_date;

