USE covid_db;

DROP TABLE IF EXISTS covid_state_cases;

CREATE TABLE covid_state_cases (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    state           VARCHAR(100) NOT NULL,
    report_date     DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0
);

INSERT INTO covid_state_cases (state, report_date, confirmed_cases) VALUES
    ('Mumbai', '2023-01-10', 1200),
    ('Mumbai', '2023-01-11', 1400),
    ('Mumbai', '2023-01-12', 2500),
    ('Mumbai', '2023-01-13', 2300),
    ('Mumbai', '2023-01-14', 2100),
    ('Mumbai', '2023-01-15', 1800),
    ('Mumbai', '2023-01-16', 1600);

SELECT c1.state, c1.report_date, c1.confirmed_cases
FROM covid_state_cases c1
WHERE c1.confirmed_cases >= ALL (
    SELECT c2.confirmed_cases
    FROM covid_state_cases c2
    WHERE c2.state = c1.state
      AND c2.report_date IN (c1.report_date - INTERVAL 1 DAY, c1.report_date + INTERVAL 1 DAY)
)
AND c1.state = 'Mumbai'
ORDER BY c1.report_date;

