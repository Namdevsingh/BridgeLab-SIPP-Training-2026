CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

CREATE TABLE IF NOT EXISTS covid_cases (
    id                         INT AUTO_INCREMENT PRIMARY KEY,
    date                       DATE NOT NULL,
    time                       TIME NOT NULL,
    state                      VARCHAR(100) NOT NULL,
    confirmed_indian_national  INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    recoveries                 INT DEFAULT 0,
    deaths                     INT DEFAULT 0,
    confirmed_cases            INT DEFAULT 0
);

DESCRIBE covid_cases;

