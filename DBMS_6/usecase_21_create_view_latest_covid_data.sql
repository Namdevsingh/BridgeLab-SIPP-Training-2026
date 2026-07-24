USE covid_db;
DROP VIEW IF EXISTS vw_latest_covid_data;
CREATE VIEW vw_latest_covid_data AS
SELECT 
    c1.country,
    c1.report_date,
    c1.confirmed_cases,
    c1.deaths,
    c1.recoveries,
    ROUND((c1.deaths / NULLIF(c1.confirmed_cases, 0)) * 100, 2) AS mortality_rate_pct,
    ROUND((c1.recoveries / NULLIF(c1.confirmed_cases, 0)) * 100, 2) AS recovery_rate_pct
FROM covid_cases c1
INNER JOIN (
    SELECT country, MAX(report_date) AS max_date
    FROM covid_cases
    GROUP BY country
) c2 ON c1.country = c2.country AND c1.report_date = c2.max_date;
SELECT * FROM vw_latest_covid_data;
