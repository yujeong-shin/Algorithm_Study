SELECT I.ID, N.FISH_NAME, LENGTH
FROM FISH_INFO AS I
JOIN FISH_NAME_INFO AS N
ON I.FISH_TYPE = N.FISH_TYPE
WHERE (I.FISH_TYPE, LENGTH) IN (
    SELECT FISH_TYPE, MAX(IFNULL(LENGTH, 0)) AS MAX_LENGTH
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
ORDER BY 1