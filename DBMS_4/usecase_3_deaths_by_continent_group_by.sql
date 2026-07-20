USE covid_db;

CREATE TABLE IF NOT EXISTS continents (
    continent_code CHAR(2) PRIMARY KEY,
    continent_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT IGNORE INTO continents (continent_code, continent_name) VALUES
    ('AS', 'Asia'),
    ('NA', 'North America'),
    ('EU', 'Europe'),
    ('OC', 'Oceania'),
    ('AF', 'Africa'),
    ('SA', 'South America');

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE,
    continent_code CHAR(2),
    population     BIGINT,
    CONSTRAINT fk_continent FOREIGN KEY (continent_code) REFERENCES continents(continent_code) ON DELETE SET NULL
);

INSERT IGNORE INTO countries (country_code, country_name, continent_code, population) VALUES
    ('IND', 'India', 'AS', 1428627663),
    ('CHN', 'China', 'AS', 1425671352),
    ('USA', 'United States of America', 'NA', 339996563),
    ('CAN', 'Canada', 'NA', 38781289),
    ('GBR', 'United Kingdom', 'EU', 67736802),
    ('DEU', 'Germany', 'EU', 83294633),
    ('AUS', 'Australia', 'OC', 26141369);

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
    ('CHN', '2023-01-15', 99000000, 120000, 97000000),
    ('USA', '2023-01-15', 102345000, 1115000, 100850000),
    ('CAN', '2023-01-15', 4500000, 48000, 4400000),
    ('GBR', '2023-01-15', 24650000, 211500, 24240000),
    ('DEU', '2023-01-15', 38000000, 175000, 37000000),
    ('AUS', '2023-01-15', 11000000, 18000, 10800000);

SELECT
    cont.continent_name,
    SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries cnt ON cc.country_code = cnt.country_code
INNER JOIN continents cont ON cnt.continent_code = cont.continent_code
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;

