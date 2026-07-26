/**
* given an (mxn) matrix of integers, return a list of all elements within 
* matrix in spiral order
*
* to solve this question, we can implement following algorithm:
*
* 1. create a list to hold result
*
* 2. create 4 boundaries:
*    -top
*    -bottom
*    -left
*    -right
*
* 3. iterate until the boundaries meet:
*    -collect all elements from top row, left to right
*     -move downward afterward
*    -collect all elements from right column, top to bottom
*     -move to the left afterward
*    -if rows remain, collect all elements from bottom row, right to left
*     -move to the right afterward
*    -if rows remain, collect all elements from left column, bottom to top
*     -move upward afterward
*
* 4. return resulting list
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // create a list to hold result
        List<Integer> result = new ArrayList<>();

        // create 4 boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // iterate until boundaries cross
        while(left <= right && top <= bottom) {
            // collect all elements from top row, left to right
            for(int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }

            // move downward
            top++;

            // collect all elements from right column, top to bottom
            for(int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }

            // move to the left
            right--;

            // if rows remain, collect all elements from bottom row,
                // right to left
            if(top <= bottom) {
                for(int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }

                // move upward
                bottom--;
            }

            // if rows remain, collect all elements from left column,
                // bottom to top
            if(left <= right) {
                for(int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }

                // move to the right
                left++;
            }
        }

        // return resulting list
        return result;
    }
}
