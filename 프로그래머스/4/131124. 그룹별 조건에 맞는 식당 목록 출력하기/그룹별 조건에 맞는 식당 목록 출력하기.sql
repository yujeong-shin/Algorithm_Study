/*
SELECT *
FROM REST_REVIEW AS A
JOIN MEMBER_PROFILE AS B
ON A.MEMBER_ID = B.MEMBER_ID
*/

SELECT C.MEMBER_NAME, A.REVIEW_TEXT, DATE_FORMAT(A.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW AS A
JOIN
(
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1
) AS B
ON A.MEMBER_ID = B.MEMBER_ID
JOIN MEMBER_PROFILE AS C
ON A.MEMBER_ID = C.MEMBER_ID
ORDER BY REVIEW_DATE, A.REVIEW_TEXT
