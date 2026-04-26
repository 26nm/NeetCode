class Solution {
    /**
    * we are given m x n 2-D integer array matrix and an integer target
    * -each row in matrix is sorted in ascending order
    * -first integer of every row is greater than the last integer of
    *  previous row
    *
    * return true if target exists within matrix or false otherwise
    *
    * to solve this problem, we should treat the matrix as a flattened
    * 1D array
    *
    * 1. set m to matrix's length (# rows)
    *    set n to matrix row length
    *
    * 2. set left -> 0
    *    set right -> m x n - 1;
    *
    * 3. while left <= right:
    *    -calc mid as left + (right - left) / 2;
    *    -calculate current row and col positions:
    *     -row -> mid / n
    *     -col -> mid % n
    *    -get current value -> matrix[row][col]
    *    -if value matches target -> return true
    *    -else if value too big -> right = mid - 1;
    *    -else -> left = mid + 1
    *
    * 4. return false
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        // init variables
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;

        // iterate until left and right meet
        while(left <= right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // calc current row and col position
            int row = mid / n;
            int col = mid % n;

            // get current matrix position
            int value = matrix[row][col];

            // if match found -> return true
            if(value == target) return true;

            // value too big
            else if(value > target) right = mid - 1;

            // value too small
            else left = mid + 1;
        }

        // value not found
        return false;
    }
}
