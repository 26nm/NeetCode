/**
* given a square (nxn) matrix of integers, rotate it 90-degrees clockwise
*
* rotate matrix in-place. do not allocate a 2d matrix
*
* to solve this question, we can implement following algorithm:
*
* 1. get # of rows from input matrix
*
* 2. transpose matrix:
*    -swap across main diagonal
*    -turn columns into rows
*
* 3. reverse each row
*/
class Solution {
    public void rotate(int[][] matrix) {
        // get # of rows from input matrix
        int n = matrix.length;

        // transpose matrix
        for(int row = 0; row < n; row++) {
            for(int col = row + 1; col < n; col++) {
                // store matrix value to be overridden
                int temp = matrix[row][col];

                // change matrix value by swapping rows and cols
                matrix[row][col] = matrix[col][row];

                // restore original matrix value
                matrix[col][row] = temp;
            }
        }

        // reverse each row
        for(int[] row : matrix) {
            // set left bound at 0, right bound at end
            int left = 0;
            int right = n - 1;

            // iterate until left & right meet
            while(left < right) {
                // temporarily store value for left bound in row
                int temp = row[left];

                // set left bound in row to right bound in row
                row[left] = row[right];

                // set right bound in row to temp
                row[right] = temp;

                // shrink from left & right
                left++;
                right--;
            }
        }
    }
}
