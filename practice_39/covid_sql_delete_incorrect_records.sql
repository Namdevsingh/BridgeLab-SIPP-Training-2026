DELETE FROM covid_cases
WHERE country = 'IN';

DELETE FROM covid_cases a
WHERE EXISTS (
    SELECT 1
    FROM covid_cases b
    WHERE b.country = a.country
      AND b.report_date = a.report_date
      AND b.confirmed_cases = a.confirmed_cases
      AND b.deaths = a.deaths
      AND b.recoveries = a.recoveries
      AND b.population = a.population
      AND b.rowid < a.rowid
);

