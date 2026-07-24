USE covid_db;
ALTER TABLE covid_cases ADD COLUMN infection_rate DECIMAL(8,2) GENERATED ALWAYS AS (ROUND((confirmed_cases / NULLIF(population, 0)) * 100000, 2)) STORED;
CREATE INDEX idx_covid_cases_infection_rate ON covid_cases(infection_rate DESC);
SELECT country, report_date, confirmed_cases, population, infection_rate FROM covid_cases ORDER BY infection_rate DESC LIMIT 10;
