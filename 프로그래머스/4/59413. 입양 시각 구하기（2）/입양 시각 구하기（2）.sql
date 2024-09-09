/*
SELECT HOUR(DATETIME), COUNT(*)
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME)
*/

SET @HOUR = -1;
SELECT @HOUR := @HOUR+1 AS HOUR,
    (
        SELECT COUNT(*)
        FROM ANIMAL_OUTS
        WHERE HOUR(DATETIME) = @HOUR
    ) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23