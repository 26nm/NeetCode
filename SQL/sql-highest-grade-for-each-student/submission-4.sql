/*
* we are given a table exam_results containing student scores for exam
* -(student_id, exam_id) is primary key for this table
* -each row represents a student's score on particular exam
* -score column never null
*
* write query to find each student's highest score along with corresponding
* exam_id
*
* to solve this, we can consider the following approach:
* 1. select student_id, exam_id, and score columns to process
*    -select student_id, exam_id, and score columns again
*    -create a row number for following:
*     -partition data by student id
*     -order data by exam scores in descending order, exam id in ascending order
*    -specify source of data as from exam_results
*
* 2. specify source as from partitioned row ranked
*
* 3. assign row number of 1
*
* 4. order results by student id
*/
-- Write your query below

-- select student_id, exam_id, and score to process
SELECT student_id, exam_id, score

-- specify source as from partitioned row called ranked
FROM (
    -- process student_id, exam_id, and score further
    SELECT 
            student_id, 
            exam_id, 
            score,
            -- create row number for partitioned data
            ROW_NUMBER() OVER (
                -- partition data by student id
                PARTITION BY student_id

                -- order by exam scores (in descending order) and exam ids (in ascending order)
                ORDER BY score DESC, exam_id ASC    
            ) AS rn
    FROM exam_results
) ranked

-- assign rank number as 1
WHERE rn = 1

-- order results by student id
ORDER BY student_id;
