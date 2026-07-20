USE covid_db;

CREATE TABLE IF NOT EXISTS countries (
    country_code   CHAR(3) PRIMARY KEY,
    country_name   VARCHAR(100) NOT NULL UNIQUE,
    continent      VARCHAR(50),
    population     BIGINT,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT IGNORE INTO countries (country_code, country_name, continent, population) VALUES
    ('IND', 'India', 'Asia', 1428627663),
    ('USA', 'United States of America', 'North America', 339996563),
    ('GBR', 'United Kingdom', 'Europe', 67736802);

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    id                         INT AUTO_INCREMENT PRIMARY KEY,
    country_code               CHAR(3) NOT NULL,
    report_date                DATE NOT NULL,
    time                       TIME,
    confirmed_indian_national  INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    recoveries                 INT DEFAULT 0,
    deaths                     INT DEFAULT 0,
    confirmed_cases            INT NOT NULL DEFAULT 0,
    last_updated               TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_country
        FOREIGN KEY (country_code)
        REFERENCES countries(country_code)
        ON DELETE CASCADE,
    CONSTRAINT unique_country_report_date UNIQUE (country_code, report_date),
    CONSTRAINT chk_deaths_vs_cases CHECK (deaths <= confirmed_cases)
);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('IND', '2020-03-15', '10:00:00', 100, 2, 50);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('USA', '2020-03-15', '10:00:00', 500, 10, 200);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('IND', '2020-03-16', '10:00:00', 150, 3, 70);

SELECT * FROM covid_cases ORDER BY country_code, report_date;

INSERT IGNORE INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('IND', '2020-03-15', '12:00:00', 120, 3, 60);

INSERT INTO covid_cases (country_code, report_date, time, confirmed_cases, deaths, recoveries)
VALUES ('IND', '2020-03-15', '12:00:00', 120, 3, 60)
ON DUPLICATE KEY UPDATE
    confirmed_cases = VALUES(confirmed_cases),
    deaths = VALUES(deaths),
    recoveries = VALUES(recoveries),
    time = VALUES(time);

SELECT * FROM covid_cases ORDER BY country_code, report_date;

