USE covid_db;

DESCRIBE covid_cases;

ALTER TABLE covid_cases
ADD COLUMN vaccination_rate FLOAT DEFAULT NULL;

DESCRIBE covid_cases;

UPDATE covid_cases
SET vaccination_rate = 72.5
WHERE state = 'India' AND date = '2020-03-15';

SELECT * FROM covid_cases;

