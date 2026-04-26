class Solution {
    /**
    * we are given an m x n 2-D integer array matrix and an int target
    * -eah row in matrix is sorted in ascending order
    * -first integer of every row is greater than last integer
    * -of previous row
    *
    * return true if target exists within matrix or false otherwise
    *
    * what if we wrote an algorithm that performed the binary search
    * for each row?
    * -in one pass, each iteration should move down a row
    * -should think about doing this in one pass as well
    *
    * 1. iterate 0 to matrix length:
    *    -int low -> 0
    *    -int high -> matrix[i].length - 1
    *    -while(low <= high)
    *     // perform typical binary search procedures
    *    -if not found -> move down a row?
    *
    * 2. return false
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        // init variables
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;

        // iterate until left and right intersect
        while(left <= right) {
            // calculate current middle
            int mid = left + (right - left) / 2;

            // calculate current matrix position
            int row = mid / n;
            int col = mid % n;

            // get current value
            int value = matrix[row][col];

            // if value matches target -> return true
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
