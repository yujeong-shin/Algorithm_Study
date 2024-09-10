SELECT B.HISTORY_ID,
    ROUND(A.DAILY_FEE * (1 - 
                   CASE
                        WHEN C.DISCOUNT_RATE IS NULL THEN 0
                        ELSE C.DISCOUNT_RATE/100
                   END
                  ) * (DATEDIFF(B.END_DATE, B.START_DATE)+1)
         , 0)
    AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B
ON A.CAR_ID = B.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C # 대여기간이 7일 미만인 경우도 결과 출력
ON A.CAR_TYPE = C.CAR_TYPE
    AND
    CASE
        WHEN DATEDIFF(B.END_DATE, B.START_DATE)+1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(B.END_DATE, B.START_DATE)+1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(B.END_DATE, B.START_DATE)+1 >= 7 THEN '7일 이상'
        ELSE NULL
    END = C.DURATION_TYPE
WHERE A.CAR_TYPE = '트럭'
ORDER BY 2 DESC, 1 DESC