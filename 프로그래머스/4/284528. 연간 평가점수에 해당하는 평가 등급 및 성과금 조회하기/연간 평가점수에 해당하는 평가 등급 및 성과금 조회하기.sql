SELECT E.EMP_NO, E.EMP_NAME, 
    CASE
        WHEN AVG(G.SCORE) >= 96 THEN 'S'
        WHEN AVG(G.SCORE) >= 90 THEN 'A'
        WHEN AVG(G.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
     CASE
        WHEN AVG(G.SCORE) >= 96 THEN E.SAL * 0.2
        WHEN AVG(G.SCORE) >= 90 THEN E.SAL * 0.15
        WHEN AVG(G.SCORE) >= 80 THEN E.SAL * 0.1
        ELSE E.SAL * 0
    END AS BONUS
FROM HR_GRADE G
JOIN HR_EMPLOYEES E
ON G.EMP_NO = E.EMP_NO
JOIN HR_DEPARTMENT D
ON E.DEPT_ID = D.DEPT_ID
GROUP BY G.EMP_NO
ORDER BY E.EMP_NO