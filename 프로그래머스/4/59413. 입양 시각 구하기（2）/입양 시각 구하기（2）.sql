
WITH RECURSIVE rc
AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1
    FROM rc
    WHERE HOUR<23
)

SELECT rc.HOUR, IFNULL(TEMP.COUNT, 0) AS COUNT
FROM rc
LEFT JOIN 
(
    SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
    FROM ANIMAL_OUTS
    GROUP BY HOUR(DATETIME)
) TEMP
ON rc.HOUR = TEMP.HOUR
ORDER BY 1