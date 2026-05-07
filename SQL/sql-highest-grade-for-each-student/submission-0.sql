/*
* we are given an exam_results table containing exam scores for students
*
* student_id and exam_id are the primary keys for this table
* -each row contains student scores for exams
* -score column never null
*
* write query to find each student's highest score along with corresponding
* exam id 
* -if student has same highest score on multiple exams, return one with
*  smallest exam id
*/
-- Write your query below

-- select student id, exam id, and score to process
SELECT student_id, exam_id, score

-- specify source as partitioned row called "ranked"
FROM (
    -- process student id, exam id, and score further
    SELECT student_id,
           exam_id,
           score,
           -- assign each row a rank
           ROW_NUMBER() OVER (
                -- partition row data by student id
                PARTITION BY student_id

                -- order exam sccores in descending order, exam ids in ascending order
                ORDER BY score DESC, exam_id ASC     
           ) AS rn
    -- specify source as exam_results table
    FROM exam_results
) ranked

-- assign row number as 1
WHERE rn = 1

-- order results by student id 
ORDER BY student_id;