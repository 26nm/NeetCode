/*
* we are given two tables person and address
*
* write a query that combines info from both
* -person_id is primary key for person (contains person's first & last + id)
* -address_id is primary key for address(links person's id to their city and state)
*
* to solve this, we can left join person and address table:
* 1. select person's first name, last name, city, state to process
*    -specify source as from person table
*
* 2. left join with address table
*    -on condition that address table references person's id
*/
-- Write your query below

-- select person's first name, last name, city, state to process
SELECT p.first_name,
        p.last_name,
        a.city,
        a.state

-- specify source as from person table
FROM person p

-- left join with address table
LEFT JOIN address a
    -- filter by addresses referencing person id
    ON p.person_id = a.person_id;
