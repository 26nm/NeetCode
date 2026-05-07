/*
* we are given 2 tables: customers and orders
* -customer_id is primary key for customers (contains id and name)
* -order_id is primary key for orders (represents order placed by customer)
*
* write query to find customers who purchased both products 'A' and 'B'
* but have never purchased product 'C'
*/
-- Write your query below

-- select customer id and name to process
SELECT c.customer_id, c.customer_name

-- specify source as customers
FROM customers c

-- join customer with order data
JOIN orders o
    ON c.customer_id = o.customer_id

-- group data by customer id and name
GROUP BY c.customer_id, c.customer_name

-- filter by customers having made at least 1 purchase for A & B, but not C
HAVING SUM(CASE WHEN o.product_name = 'A' THEN 1 ELSE 0 END) > 0
    AND SUM(CASE WHEN o.product_name = 'B' THEN 1 ELSE 0 END) > 0
    AND SUM(CASE WHEN o.product_name = 'C' THEN 1 ELSE 0 END) = 0

-- order results by customer name
ORDER BY c.customer_name;
