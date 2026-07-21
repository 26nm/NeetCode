class Solution {
    public void rotate(int[][] matrix) {
        // get # of rows from input matrix
        int n = matrix.length;

        // transpose matrix
        for(int row = 0; row < n; row++) {
            for(int col = row + 1; col < n; col++) {
                // store matrix value to be changed
                int temp = matrix[row][col];

                // change matrix value by swapping 
                    // row and col values
                matrix[row][col] = matrix[col][row];

                // restore original values
                matrix[col][row] = temp;
            }
        }

        // reverse each row
        for(int[] row : matrix) {
            // set left bound at 0 and right bound at end
            int left = 0;
            int right = n - 1;

            // iterate until boundaries meet
            while(left < right) {
                // temporarily store left bound value
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
