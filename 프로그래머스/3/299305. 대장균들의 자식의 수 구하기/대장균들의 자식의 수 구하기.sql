SELECT A.ID, COUNT(B.ID) AS CHILD_COUNT
FROM ECOLI_DATA AS A
LEFT JOIN ECOLI_DATA AS B
ON A.ID = B.PARENT_ID
GROUP BY A.ID
ORDER BY A.ID

/*
SELECT *
FROM ECOLI_DATA AS A
LEFT JOIN ECOLI_DATA AS B
ON A.ID = B.PARENT_ID
ORDER BY A.ID
*/

/*
SELECT ID,
IFNULL (
    (
    SELECT COUNT(*)
    FROM ECOLI_DATA
    GROUP BY PARENT_ID
    HAVING PARENT_ID = ID
    ), 0
) AS CHILD_COUNT
FROM ECOLI_DATA
ORDER BY ID
*/