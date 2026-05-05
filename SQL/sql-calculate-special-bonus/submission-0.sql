/*
* we are given a table employees with employee info
* -employee id is primary key for this table
* -each row contains employee id, name, salary
*
* write query to calculate bonus for each employee
* -employee receives bonus equal to 100% of salary if:
*  -employee id is odd AND
*  -name doesn't start with M
*
* otherwise no bonus
*/
-- Write your query below

-- process employee id
SELECT employee_id,

-- process ids that are odd and don't start with M
        CASE
            WHEN employee_id % 2 = 1
            AND name NOT LIKE 'M%'

-- apply salary bonus if true
            THEN salary

-- no salary bonus
            ELSE 0

        END as bonus

-- specify source as employee table
FROM employees

-- order by employee id
ORDER BY employee_id;
