/**
* given an (mxn) matrix of integers, return a list of all elements within
* matrix in spiral order
*
* to solve this question, we can implement the following algorithm:
*
* 1. collect all elements from left to right along top row
*    -move downward
*
* 2. collect all elements from top to bottom along right column
*    -move to the left
*
* 3. if elements remain -> collect all elements from right to left
*    along bottom row
*    -move upward 
*
* 4. if elements remain -> collect all elements from bottom to top
*    along left column
*    -move to the right
*
* 5. return resulting list
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // create list to hold result
        List<Integer> result = new ArrayList<>();

        // create 4 boundaries: top, bottom, left, right
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // iterate until boundaries cross
        while(left <= right && top <= bottom) {
            // collect all elements from left to right on top row
            for(int col = top; col <= right; col++) {
                result.add(matrix[top][col]);
            }

            // move downward
            top++;

            // collect all elements from top to bottom on right column
            for(int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }

            // move to the left
            right--;

            // if elements remain -> collect elements from right to left
                // on bottom row
            if(top <= bottom) {
                for(int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }

                // move upward
                bottom--;
            }

            // if elements remain -> collect elements from bottom to top
                // on left column
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
