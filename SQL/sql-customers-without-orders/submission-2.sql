-- Write your query below

/*
* we are given two tables customers and orders
*
* id is primary key for both customers and orders
*
* in customers, each row contains id and name for customer
*
* in orders, each row contains order id and customer id
*
* write query to find all customers who never ordered, return their
* names
*
* to solve this:
* 1. process customer id from customers
*
* 2. left join with orders -> pair customer id with their id in orders table
*
* 3. filter by null order ids
*/

-- process customer name
SELECT c.name

-- specify it's from customers
FROM customers c

-- left join with orders, pair customer id with their id in order table
LEFT JOIN orders o
    ON c.id = o.customer_id

-- filter by null order ids
WHERE o.id IS NULL;