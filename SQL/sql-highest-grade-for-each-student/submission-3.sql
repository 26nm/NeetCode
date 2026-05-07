/*
* we're given a table exam_results containing exam scores
*
* student_id, exam_id is primary key for this table
* -it contains student score for particular exams
*
* write query to find each student's highest score along with
* corresponding exam_id
*
* to solve this question, we can consider following approach:
* 1. select student id, exam id, score to process
*    -process these columns further:
*     -select student id, exam id, and score to process again
*     -assign the following a row number:
*      -partition by student id
*      -list exam scores in descending order, exam id numbers in ascending order
*
* 2. specify their source as from partitioned row called ranked
*
* 3. assign this partitioned row a rank of 1
*
* 4. order results by student id
*/
-- Write your query below

-- process student id, exam id, and scores
SELECT student_id, exam_id, score
    -- process them further
FROM (
    -- select student id, exam id, and scores to process again
    SELECT student_id, 
           exam_id,
           score,
           ROW_NUMBER() OVER (
                -- partition by student id
                PARTITION BY student_id

                -- list exam scores in descending order, exam ids in ascending order
                ORDER BY score DESC, exam_id ASC
           ) rn
    -- specify source as exam_results
    FROM exam_results
) ranked

-- assign row rank of 1
WHERE rn = 1

-- order by student id
ORDER BY student_id;
