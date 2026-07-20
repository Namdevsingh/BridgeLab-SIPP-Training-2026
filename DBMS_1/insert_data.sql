USE covid_db;

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
    ('India', '2023-01-01', 44678900, 530800, 44123000, 1428627663),
    ('India', '2023-01-15', 44712300, 531100, 44156000, 1428627663),
    ('India', '2023-02-01', 44756700, 531500, 44198000, 1428627663);

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
    ('USA', '2023-01-01', 102000000, 1112000, 100500000, 339996563),
    ('USA', '2023-01-15', 102345000, 1115000, 100850000, 339996563),
    ('USA', '2023-02-01', 102789000, 1119000, 101200000, 339996563);

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
    ('UK', '2023-01-01', 24600000, 211000, 24200000, 67736802),
    ('UK', '2023-01-15', 24650000, 211500, 24240000, 67736802),
    ('UK', '2023-02-01', 24710000, 212000, 24290000, 67736802);

INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
    ('India', '2023-03-01', 44890000, 532500, 44250000, 1428627663),
    ('USA',   '2023-03-01', 103500000, 1125000, 101900000, 339996563),
    ('UK',    '2023-03-01', 24800000, 212800, 24350000, 67736802);

SELECT * FROM covid_cases ORDER BY country, report_date;

