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

DROP TABLE IF EXISTS covid_vaccines;

CREATE TABLE covid_vaccines (
    vaccine_id             INT AUTO_INCREMENT PRIMARY KEY,
    country_code           CHAR(3) NOT NULL,
    report_date            DATE NOT NULL,
    total_vaccinations     BIGINT DEFAULT 0,
    people_vaccinated      BIGINT DEFAULT 0,
    people_fully_vaccinated BIGINT DEFAULT 0,
    CONSTRAINT fk_vaccine_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

INSERT INTO covid_deaths (country_code, report_date, total_deaths, new_deaths) VALUES
    ('IND', '2023-01-15', 531100, 1200),
    ('USA', '2023-01-15', 1115000, 3500),
    ('GBR', '2023-01-15', 211500, 800),
    ('CAN', '2023-01-15', 48000, 150),
    ('AUS', '2023-01-15', 18000, 50);

INSERT INTO covid_vaccines (country_code, report_date, total_vaccinations, people_vaccinated, people_fully_vaccinated) VALUES
    ('IND', '2023-01-15', 2200000000, 950000000, 850000000),
    ('USA', '2023-01-15', 650000000, 270000000, 230000000),
    ('GBR', '2023-01-15', 150000000, 54000000, 50000000);

SELECT
    cnt.country_name,
    cd.total_deaths,
    cd.new_deaths,
    cv.total_vaccinations,
    cv.people_vaccinated,
    cv.people_fully_vaccinated
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv ON cd.country_code = cv.country_code AND cd.report_date = cv.report_date
INNER JOIN countries cnt ON cd.country_code = cnt.country_code
ORDER BY cnt.country_name;

