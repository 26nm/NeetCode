-- Write your query below

-- choose customer_id to process
SELECT customer_id

-- specify where data is from
FROM customers

-- filter by year and revenue
WHERE year = 2020
    AND revenue > 0;
