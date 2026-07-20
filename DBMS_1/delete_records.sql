USE covid_db;

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('IN', '2023-01-01', 44678900, 530800, 44123000, 1428627663);

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('India', '2023-01-01', 44678900, 530800, 44123000, 1428627663);

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('United States', '2023-01-01', 102000000, 1112000, 100500000, 339996563);

SELECT * FROM covid_cases ORDER BY country, report_date;

DELETE FROM covid_cases
WHERE country = 'IN';

SELECT cc.case_id, cc.country, cc.report_date
FROM covid_cases cc
JOIN (
    SELECT country, report_date, MIN(case_id) AS min_id
    FROM covid_cases
    GROUP BY country, report_date
    HAVING COUNT(*) > 1
) dup ON cc.country = dup.country AND cc.report_date = dup.report_date
WHERE cc.case_id > dup.min_id;

DELETE cc
FROM covid_cases cc
JOIN (
    SELECT country, report_date, MIN(case_id) AS min_id
    FROM covid_cases
    GROUP BY country, report_date
    HAVING COUNT(*) > 1
) dup ON cc.country = dup.country AND cc.report_date = dup.report_date
WHERE cc.case_id > dup.min_id;

DELETE FROM covid_cases
WHERE country = 'United States';

SELECT * FROM covid_cases ORDER BY country, report_date;

