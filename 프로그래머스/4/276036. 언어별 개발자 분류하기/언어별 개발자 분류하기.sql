/*
## 타인 정답 코드
## 프론트엔드에 해당하는 기술들을 모두 더한 뒤 각 개발자의 보유 스킬과 & 연산 했을 때,
## 하나라도 같은 부분이 있다면 해당 개발자는 프론트엔드 기술을 보유한 개발자다.
SELECT (
        CASE
            WHEN (SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY LIKE 'FRONT%')) 
                AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'PYTHON') THEN 'A'
            WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') THEN 'B'
            WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY LIKE 'FRONT%') THEN 'C'
            ELSE NULL
        END) AS GRADE, ID, EMAIL
FROM DEVELOPERS
GROUP BY GRADE, ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID
*/

WITH 
TEMP_FE AS (
    SELECT SUM(CODE) AS TEMP_FE FROM SKILLCODES WHERE CATEGORY	= 'Front End'
),
TEMP_PY AS (
    SELECT CODE AS TEMP_PY FROM SKILLCODES WHERE NAME = 'Python'
),
TEMP_C AS(
    SELECT CODE AS TEMP_C FROM SKILLCODES WHERE NAME = 'C#'
)

SELECT
    CASE
        WHEN (SKILL_CODE & TEMP_FE) AND (SKILL_CODE & TEMP_PY) THEN 'A'
        WHEN (SKILL_CODE & TEMP_C) THEN 'B'
        WHEN (SKILL_CODE & TEMP_FE) THEN 'C'
        ELSE NULL
    END AS GRADE,
    D.ID, D.EMAIL
FROM DEVELOPERS D, TEMP_FE, TEMP_PY, TEMP_C
GROUP BY GRADE, ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID