UPDATE covid_cases
SET confirmed_cases = confirmed_cases + 5000,
    deaths = deaths + 50,
    recoveries = recoveries + 2000
WHERE country = 'India' AND report_date = '2020-06-01';

