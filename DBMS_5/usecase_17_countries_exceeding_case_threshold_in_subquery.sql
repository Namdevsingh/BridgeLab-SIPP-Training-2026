USE covid_db;

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE
);

INSERT IGNORE INTO countries (country_code, country_name) VALUES
    ('IND', 'India'),
    ('USA', 'United States of America'),
    ('GBR', 'United Kingdom'),
    ('CAN', 'Canada'),
    ('AUS', 'Australia');

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    country_code    CHAR(3) NOT NULL,
    report_date     DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths          INT DEFAULT 0,
    recoveries      INT DEFAULT 0,
    CONSTRAINT fk_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

INSERT INTO covid_cases (country_code, report_date, confirmed_cases, deaths, recoveries) VALUES
    ('IND', '2023-01-15', 44712300, 531100, 44156000),
    ('USA', '2023-01-15', 102345000, 1115000, 100850000),
    ('GBR', '2023-01-15', 24650000, 211500, 24240000),
    ('CAN', '2023-01-15', 4500000, 48000, 4400000),
    ('AUS', '2023-01-15', 11000000, 18000, 10800000),
    ('XYZ', '2023-01-15', 500000, 1000, 400000);

SELECT country_name
FROM countries
WHERE country_code IN (
    SELECT country_code
    FROM covid_cases
    GROUP BY country_code
    HAVING MAX(confirmed_cases) > 1000000
);

