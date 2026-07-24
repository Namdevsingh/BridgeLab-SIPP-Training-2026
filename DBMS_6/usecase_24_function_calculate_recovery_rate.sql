USE covid_db;
DROP FUNCTION IF EXISTS CalculateRecoveryRate;
DELIMITER $$
CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(6,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT;
    DECLARE v_recoveries INT;
    DECLARE v_rate DECIMAL(6,2);
    SELECT confirmed_cases, recoveries INTO v_confirmed, v_recoveries
    FROM covid_cases
    WHERE country = p_country AND report_date = p_date
    LIMIT 1;
    IF v_confirmed IS NULL OR v_confirmed = 0 THEN
        SET v_rate = 0.00;
    ELSE
        SET v_rate = ROUND((v_recoveries / v_confirmed) * 100, 2);
    END IF;
    RETURN v_rate;
END$$
DELIMITER ;
SELECT 
    country,
    report_date,
    confirmed_cases,
    recoveries,
    CalculateRecoveryRate(country, report_date) AS recovery_rate_pct
FROM covid_cases
ORDER BY country, report_date;
