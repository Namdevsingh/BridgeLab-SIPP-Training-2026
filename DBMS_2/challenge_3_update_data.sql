USE covid_db;

SELECT * FROM covid_cases
WHERE state = 'India' AND date = '2020-03-15';

UPDATE covid_cases
SET confirmed_cases = 120
WHERE state = 'India'
  AND date = '2020-03-15';

SELECT * FROM covid_cases
WHERE state = 'India' AND date = '2020-03-15';

SELECT * FROM covid_cases;

