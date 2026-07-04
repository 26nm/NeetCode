/**
* you are given a 2d grid of integers matrix, where each integer >= 0
*
* return length of longest strictly increasing path within matrix
*
* from each cell within path, you can move either horizontally or vertically
* -diagonal not allowed
*
* to solve this question, we can implement multi-source DFS and mix it with
* DP:
*
* helper:
* 1. if current row & col in dp not 0 -> return its value
*
* 2. track longest so far, start at 1
*
* 3. iterate through directions:
*    -get next row & col
*    -if next row & col out of bounds -> skip
*    -if next row & col in matrix <= current row & col 
*     in matrix -> skip it
*    -update longest to max of it and dfs iterations
*
* 4. update row & col in dp to longest
*
* 5. return longest
*
* main function
* 1. get # of rows & cols
*
* 2. track longest so far, start at 0
*
* 3. create 2d dp array of size rows x cols
*
* 4. traverse board:
*    -update longest to max of itself and dfs calls
*
* 5. return longest
*/
class Solution {
    // 2d array to represent direction
    private final int[][] directions = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };
    // helper function to perform dfs
    private int dfs(int[][] matrix, int[][] dp, int row, int col) {
        // if current row & col in dp NOT 0 -> return current value
        if(dp[row][col] != 0) return dp[row][col];

        // track longest so far, start at 1
        int longest = 1;

        // iterate through directions
        for(int[] dir : directions) {
            // get next row & col
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            // if out of bounds -> skip
            if(nextRow < 0 || nextRow >= matrix.length
                || nextCol < 0 || nextCol >= matrix[0].length) 
                    continue;

            // if less than neighbor -> skip it
            if(matrix[nextRow][nextCol] <= matrix[row][col])
                continue;

            // update longest to max of itself and value from dfs iterations
            longest = Math.max(longest, 1 + dfs(matrix, dp, nextRow, nextCol));
        }

        // update row & col in dp to longest
        dp[row][col] = longest;

        // return longest
        return longest;
    }
    
    // main function
    public int longestIncreasingPath(int[][] matrix) {
        // get # of rows & cols
        int rows = matrix.length;
        int cols = matrix[0].length;

        // track longest distance, start at 0
        int longest = 0;

        // create 2d dp array of size rows x cols
        int[][] dp = new int[rows][cols];

        // traverse board
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                // update longest
                longest = Math.max(longest, dfs(matrix, dp, r, c));
            }
        }

        // return longest
        return longest;
    }
}
