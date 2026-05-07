/*
* we are given a table exam_results containing student scores
*
* student_id, exam_id is primary key for this table
*
* write a query to find each student's highest score along with corresponding 
* exam id
*
* to solve this question, we can use the following approach:
* 1. select student id, exam id, and score to process
*    -specify that they'll processed further as partitioned row
*     -select student id, exam id, and score (again) to process further
*     -
*
* 2. specify source as a partitioned row called rank
*
* 3. set this row's ranking to 1
*
* 4. order this data by student id in ascending order
*/
-- Write your query below

-- select student id, exam id, and scores to process
SELECT student_id, exam_id, score

-- specify source as partition row called ranked
FROM (
    -- process student id, exam id, and scores further
    SELECT student_id,
           exam_id,
           score,

           -- assign each row a rank
           ROW_NUMBER() OVER (
                -- partition row data by student_id
                PARTITION BY student_id

                -- order exam scores in descending order, exam ids in ascending
                ORDER BY score DESC, exam_id ASC
           ) as rn

    -- specify source as from exam_results
    FROM exam_results
) ranked

-- assign row number as 1
where RN = 1

-- order results by student id
ORDER BY student_id;
