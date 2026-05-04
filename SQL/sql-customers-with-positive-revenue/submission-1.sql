-- Write your query below

/*
* we are given a table customers which tracks customer revenue across
* different years
*
* write query to find all customers with positive revenue in 2020
*
* to solve this, we can use row-level filtering:
* 1. select customer id column
*
* 2. specify it's from customers table
*
* 3. filter by year and revenue
*/

-- select customer id column
SELECT customer_id

-- specify it's from customers
FROM customers

-- filter by year and revenue
WHERE year = 2020
    AND revenue > 0;
