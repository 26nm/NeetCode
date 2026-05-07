/*
* we are given two tables customers and orders
* -customer_id is primary key for customers (contains id and name)
* -order_id is primary key for orders (references customer id)
*
* write query to find customers who purchased both products A & B but not C
*
* to solve this, we can consider following approach:
* 1. select customer id and name columns to process
*    -specify source as customers table
*
* 2. join them with orders o
*    -match customer id with logged customer id in order table
*
* 3. group each order by customer id and name
*
* 4. filter orders such that:
*    -orders for Product A >= 1
*    -orders for Product B >= 1
*    -orders for Product C >= 1
*
* 5. order results by customer name
*/
-- Write your query below

-- select customer id and name columns to process
SELECT c.customer_id, c.customer_name

-- specify source as customers table
FROM customers c

-- join data with data from orders table
JOIN orders o

    -- pair customer id with id from order table
    ON c.customer_id = o.customer_id

-- group orders by customer name and id
GROUP BY c.customer_id, c.customer_name

-- filter orders such that at least 1 order placed for A & B but not C
HAVING SUM(CASE WHEN o.product_name = 'A' THEN 1 ELSE 0 END) > 0
    AND SUM(CASE WHEN o.product_name = 'B' THEN 1 ELSE 0 END) > 0
    AND SUM(CASE WHEN o.product_name = 'C' THEN 1 ELSE 0 END) = 0

-- order by customer name
ORDER BY c.customer_name;
