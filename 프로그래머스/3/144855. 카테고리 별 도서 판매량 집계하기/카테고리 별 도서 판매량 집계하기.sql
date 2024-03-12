-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK B JOIN BOOK_SALES BS
ON B.BOOK_ID = BS.BOOK_ID
WHERE YEAR(BS.SALES_DATE) = '2022' AND MONTH(BS.SALES_DATE) = '01'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY
;