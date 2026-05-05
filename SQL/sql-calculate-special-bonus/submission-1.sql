/*
* we are given an employees table containing employee info
* -employee id is primary key for this table
* -each row contains id, name, and salary
*
* write query to calculate bonus for each employee
* -they receive bonus if:
*  -id is odd number
*  -name doesnt start with 'M'
* -otherwise they do not get bonus
*
* order result by employee id
*
* to solve this, we:
* 1. select employee ID column to process
*
* 2. consider case when:
*    -their id number not odd
*    -name doesnt start with 'M'
*
* 3. apply bonus if condition met, 0 otherwise
*
* 4. specify source of column data as employees
*
* 5. order results by id number
*/
-- Write your query below

-- select id column to process
SELECT employee_id,

-- consider cases of odd id numbers and names not starting with M
        CASE
            WHEN employee_id % 2 = 1
            AND name NOT LIKE 'M%'

-- if conditions hold, apply bonus
            THEN salary

-- conditions not met, no bonus granted
            ELSE 0
        END AS bonus

-- specify source as employees table
FROM employees

-- order by employee id
ORDER BY employee_id;
