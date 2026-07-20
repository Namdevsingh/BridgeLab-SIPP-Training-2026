USE covid_db;

INSERT INTO covid_cases (date, time, state, confirmed_indian_national, confirmed_foreign_national, recoveries, deaths, confirmed_cases)
VALUES ('2020-03-15', '10:00:00', 'IN', 90, 10, 50, 2, 100);

SELECT * FROM covid_cases;

DELETE FROM covid_cases
WHERE state = 'IN';

SELECT * FROM covid_cases;

