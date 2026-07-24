USE covid_db;
EXPLAIN SELECT c.country, c.report_date, c.confirmed_cases, c.deaths, c.recoveries, d.total_deaths, v.total_vaccinations FROM covid_cases c LEFT JOIN covid_deaths d ON c.country = d.country AND c.report_date = d.report_date LEFT JOIN covid_vaccines v ON c.country = v.country AND c.report_date = v.report_date WHERE c.country = 'India' AND c.report_date >= '2023-01-01';
EXPLAIN SELECT country, report_date, confirmed_cases, deaths, recoveries FROM covid_cases WHERE report_date BETWEEN '2023-01-01' AND '2023-03-01';
SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME, SEQ_IN_INDEX, NON_UNIQUE FROM INFORMATION_SCHEMA.STATISTICS WHERE TABLE_SCHEMA = 'covid_db' ORDER BY TABLE_NAME, INDEX_NAME;
