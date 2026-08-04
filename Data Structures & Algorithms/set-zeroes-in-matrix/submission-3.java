/**
* given an mxn matrix of integers, if an element is 0, set its entire row and 
* column to 0s
*
* update the matrix in place
*
* to solve this question, we can implement the following algorithm:
*
* 1. get # of rows and cols from input array
*
* 2. track whether 1st row originally needs to be zeroed, set to false
*
* 3. iterate through first row:
*    -if '0' is encountered, set to true
*    -break
*
* 4. iterate through the grid, excluding the first row:
*    -if a '0' is encountered, set 1st elems of current row & col to 0
*
* 5. iterate again, excluding first row & col:
*    -set all elements in marked rows & cols to '0'
*
* 6. '0' the first column if necessary
*    -'0' the first row as well if necessary
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // get # of rows & cols
        int rows = matrix.length;
        int cols = matrix[0].length;

        // track whether 1st row needs to be 0'd, set to false
        boolean firstRowZero = false;

        // determine if 1st row needs to be zeroed
        for(int col = 0; col < cols; col++) {
            if(matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // traverse grid, excluding 1st row to mark 0s
        for(int row = 1; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // traverse grid again, excluding 1st row & cols to 0
            // marked columns
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // 0 first col if necessary
        if(matrix[0][0] == 0) {
            for(int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }

        // 0 first row if necessary
        if(firstRowZero) {
            for(int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
