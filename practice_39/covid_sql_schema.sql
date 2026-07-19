CREATE TABLE covid_cases (
    country VARCHAR(100),
    report_date DATE,
    confirmed_cases BIGINT,
    deaths BIGINT,
    recoveries BIGINT,
    population BIGINT
);

CREATE TABLE covid_deaths (
    country VARCHAR(100),
    report_date DATE,
    deaths BIGINT
);

CREATE TABLE covid_vaccines (
    country VARCHAR(100),
    report_date DATE,
    vaccination_rate DECIMAL(10, 4)
);

