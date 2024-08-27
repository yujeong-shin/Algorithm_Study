
WITH RECURSIVE rc
AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1
    FROM rc
    WHERE HOUR<23
)
        
#SELECT rc.HOUR
#FROM rc

SELECT rc.HOUR, COUNT(outs.DATETIME) AS COUNT
FROM rc
LEFT JOIN ANIMAL_OUTS AS outs
ON rc.HOUR = HOUR(outs.DATETIME)
GROUP BY rc.HOUR
ORDER BY rc.HOUR

/*
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
ORDER BY HOUR
*/