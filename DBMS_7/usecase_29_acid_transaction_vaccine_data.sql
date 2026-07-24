USE covid_db;
DROP PROCEDURE IF EXISTS InsertVaccineDataAtomic;
DELIMITER $$
CREATE PROCEDURE InsertVaccineDataAtomic(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_total_vaccinations BIGINT,
    IN p_people_vaccinated BIGINT,
    IN p_people_fully_vaccinated BIGINT,
    IN p_population BIGINT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    START TRANSACTION;
    INSERT INTO covid_vaccines (country, report_date, total_vaccinations, people_vaccinated, people_fully_vaccinated, population)
    VALUES (p_country, p_date, p_total_vaccinations, p_people_vaccinated, p_people_fully_vaccinated, p_population);
    INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
    VALUES (p_country, p_date, 0, 0, 0, p_population)
    ON DUPLICATE KEY UPDATE population = p_population;
    COMMIT;
END$$
DELIMITER ;
CALL InsertVaccineDataAtomic('India', '2023-05-01', 2200000000, 1500000000, 700000000, 1428627663);
CALL InsertVaccineDataAtomic('USA', '2023-05-01', 670000000, 400000000, 270000000, 339996563);
SELECT * FROM covid_vaccines WHERE report_date = '2023-05-01';
SELECT * FROM covid_cases WHERE report_date = '2023-05-01';
