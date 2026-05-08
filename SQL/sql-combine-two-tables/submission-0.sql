-- Write your query below

-- select first name, last name, city, and state to process
SELECT p.first_name,
        p.last_name,
        a.city,
        a.state

-- specify source as from person table
FROM person p

-- left join with address table
LEFT JOIN address a
    -- choose rows where person id referenced in address table
    ON p.person_id = a.person_id;