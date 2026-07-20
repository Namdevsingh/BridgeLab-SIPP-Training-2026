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

DROP TABLE IF EXISTS covid_deaths;

CREATE TABLE covid_deaths (
    death_id      INT AUTO_INCREMENT PRIMARY KEY,
    country_code  CHAR(3) NOT NULL,
    report_date   DATE NOT NULL,
    total_deaths  INT DEFAULT 0,
    new_deaths    INT DEFAULT 0,
    CONSTRAINT fk_death_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

INSERT INTO covid_deaths (country_code, report_date, total_deaths, new_deaths) VALUES
    ('IND', '2023-01-13', 528700, 1100),
    ('USA', '2023-01-13', 1108000, 3200),
    ('GBR', '2023-01-13', 210200, 750),
    ('IND', '2023-01-14', 529900, 1200),
    ('USA', '2023-01-14', 1111500, 3500),
    ('GBR', '2023-01-14', 210950, 750),
    ('IND', '2023-01-15', 531100, 1200),
    ('USA', '2023-01-15', 1115000, 3500),
    ('GBR', '2023-01-15', 211500, 550);

SELECT
    report_date,
    AVG(new_deaths) AS avg_new_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;

