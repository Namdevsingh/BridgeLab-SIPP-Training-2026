USE covid_db;

DESCRIBE covid_cases;

ALTER TABLE covid_cases
ADD COLUMN vaccination_rate DECIMAL(5,2) DEFAULT NULL;

DESCRIBE covid_cases;

UPDATE covid_cases
SET vaccination_rate = 72.50
WHERE country = 'India';

UPDATE covid_cases
SET vaccination_rate = 81.30
WHERE country = 'USA';

UPDATE covid_cases
SET vaccination_rate = 79.10
WHERE country = 'UK';

SELECT country, report_date, confirmed_cases, vaccination_rate
FROM covid_cases
ORDER BY country, report_date;

ALTER TABLE covid_cases
ADD CONSTRAINT chk_vaccination_rate
CHECK (vaccination_rate >= 0 AND vaccination_rate <= 100);

