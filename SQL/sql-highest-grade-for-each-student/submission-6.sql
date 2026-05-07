/*
* we are given a table exam_results containing student exam scores
* -(student_id, exam_id) is primary key for this table
* -each row represents student's score on particular exam
* -score column never null
*
* write query to find each student's highest score along with its
* corresponding exam_id
*
* return student_id, exam_id and score, ordered by student_id
* 
* to solve this, we can consider the following approach:
* 1. select student_id, exam_id, and score to process
*    -select student_id, exam_id, and score (again) for futher processing
*    -assign the following a row number:
*     -data partitioning by student id
*     -exam scores ordered in descending order, exam ids ordered in ascending
* 
* 2. specify source as from partitioned row called ranked
*
* 3. assign row number as 1
*
* 4. order results by student id
*/
-- Write your query below

-- select student id, exam id, and scores to process
SELECT student_id, exam_id, score

-- specify source as from partitioned row called ranked
FROM (
    -- process student id, exam id, and scores further
    SELECT
            student_id,
            exam_id,
            score,

            -- assign row numbers
            ROW_NUMBER() OVER (
                -- partition data by student id
                PARTITION BY student_id

                -- order exam scores in descending, exam ids in ascending
                ORDER BY score DESC, exam_id ASC
            ) AS rn
    
    -- specify source as from exam_results
    FROM exam_results
) ranked

-- assign row number of 1
WHERE rn = 1

-- order results by student id
ORDER BY student_id;
