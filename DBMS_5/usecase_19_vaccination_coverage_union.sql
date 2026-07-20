USE covid_db;

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE,
    population     BIGINT
);

INSERT IGNORE INTO countries (country_code, country_name, population) VALUES
    ('IND', 'India', 1428627663),
    ('USA', 'United States of America', 339996563),
    ('GBR', 'United Kingdom', 67736802);

DROP TABLE IF EXISTS covid_vaccines;

CREATE TABLE covid_vaccines (
    vaccine_id             INT AUTO_INCREMENT PRIMARY KEY,
    country_code           CHAR(3) NOT NULL,
    report_date            DATE NOT NULL,
    people_vaccinated      BIGINT DEFAULT 0,
    CONSTRAINT fk_vaccine_country FOREIGN KEY (country_code) REFERENCES countries(country_code) ON DELETE CASCADE
);

INSERT INTO covid_vaccines (country_code, report_date, people_vaccinated) VALUES
    ('IND', '2023-01-15', 950000000),
    ('USA', '2023-01-15', 270000000),
    ('GBR', '2023-01-15', 54000000);

SELECT cnt.country_name, 'Vaccinated' AS coverage_type, cv.people_vaccinated AS count
FROM covid_vaccines cv
INNER JOIN countries cnt ON cv.country_code = cnt.country_code

UNION

SELECT cnt.country_name, 'Unvaccinated' AS coverage_type, (cnt.population - cv.people_vaccinated) AS count
FROM covid_vaccines cv
INNER JOIN countries cnt ON cv.country_code = cnt.country_code

ORDER BY country_name, coverage_type;

