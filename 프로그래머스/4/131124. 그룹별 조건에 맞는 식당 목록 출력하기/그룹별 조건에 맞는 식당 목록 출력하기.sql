
SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R
JOIN (
    SELECT MEMBER_ID
    FROM REST_REVIEW 
    GROUP BY MEMBER_ID
    ORDER BY COUNT(MEMBER_ID) DESC
    LIMIT 1
) TEMP
ON R.MEMBER_ID = TEMP.MEMBER_ID
JOIN MEMBER_PROFILE P
ON P.MEMBER_ID = R.MEMBER_ID
ORDER BY REVIEW_DATE, R.REVIEW_TEXT
