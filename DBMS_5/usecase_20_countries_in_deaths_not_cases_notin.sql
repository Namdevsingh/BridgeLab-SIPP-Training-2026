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
    CONSTRAINT fk_cases_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

DROP TABLE IF EXISTS covid_deaths;

CREATE TABLE covid_deaths (
    death_id      INT AUTO_INCREMENT PRIMARY KEY,
    country_code  CHAR(3) NOT NULL,
    report_date   DATE NOT NULL,
    total_deaths  INT DEFAULT 0,
    CONSTRAINT fk_death_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

INSERT INTO covid_cases (country_code, report_date, confirmed_cases) VALUES
    ('IND', '2023-01-15', 44712300),
    ('USA', '2023-01-15', 102345000),
    ('GBR', '2023-01-15', 24650000);

INSERT INTO covid_deaths (country_code, report_date, total_deaths) VALUES
    ('IND', '2023-01-15', 531100),
    ('USA', '2023-01-15', 1115000),
    ('GBR', '2023-01-15', 211500),
    ('CAN', '2023-01-15', 48000),
    ('AUS', '2023-01-15', 18000);

SELECT cnt.country_name
FROM countries cnt
WHERE cnt.country_code IN (
    SELECT cd.country_code
    FROM covid_deaths cd
    WHERE cd.country_code NOT IN (
        SELECT cc.country_code
        FROM covid_cases cc
    )
);

