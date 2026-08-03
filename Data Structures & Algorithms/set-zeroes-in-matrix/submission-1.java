class Solution {
    public void setZeroes(int[][] matrix) {
        // get # of rows and cols from input
        int rows = matrix.length;
        int cols = matrix[0].length;

        // track whether 1st row originally contains 0,
            // start with false
        boolean firstRowZero = false;

        // determine if 1st row originally contains 0
        for(int col = 0; col < cols; col++) {
            if(matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // traverse matrix, excluding 1st row & col
        for(int row = 1; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // whenever 0 is found, set 1st elem of
                    // that row and col to 0
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // traverse matrix again, excluding 1st row & col
            // to 0 marked columns
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                // if 1st elem in current row or col contains 0,
                    // 0 entire row & col
                if(matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // 0 1st column if needed
        if(matrix[0][0] == 0) {
            for(int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }

        // 0 1st row if needed
        if(firstRowZero) {
            for(int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
