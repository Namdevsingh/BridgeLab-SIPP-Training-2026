USE covid_db;
CREATE INDEX idx_covid_cases_country_date ON covid_cases(country, report_date);
CREATE INDEX idx_covid_cases_report_date ON covid_cases(report_date);
SHOW INDEX FROM covid_cases;
