-- Write your query below

/*
* we are given 2 tables: customers and orders
*
* id is primary key for this table (customers). each row contains
* ID and name for customer
*
* id is also primary key for this table (orders). customer id references
* id from customers table. each row contains id of an order and id
* of customers who placed it
*
* write query to find all customers who have never placed an order
*/

-- select customer name to process
SELECT c.name

-- specify it's from customers table
FROM customers c

-- left join customers, pair customer id with their id from orders table
LEFT JOIN orders o
    ON c.id = o.customer_id

-- filter for null order ids
WHERE o.id IS NULL;
