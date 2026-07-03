/**
 * you are given a 2D grid of integers matrix, where each integer is >= 0
 *
 * return length of longest strictly increasing path within matrix
 * -from each cell within path, you can move either horizontally or vertically
 * -diagonal not allowed
 *
 * to solve this question, we can implement multi-source DFS and memoization:
 *
 * helper:
 * 1. iterate through 2d directions array:
 *    -track longest so far, start at distance 1
 *    -get next row & cell to explore
 *    -if this cell pair NOT 0 -> return current value
 *    -if this cell pair out of bounds -> skip over it
 *    -if this cell pair smaller than neighbor -> skip it
 *    -update longest to whatever is bigger of itself or
 *     subsequent dfs iterations
 *    -update row and col in dp to this value
 *
 * 2. return longest
 *
 * main function:
 * 1. get # of rows & cols
 *    -make 2d dp array of size rows x cols
 *
 * 2. track distance so far, start at 1
 *
 * 3. iterate through board:
 *    -update longest to dfs at each cell
 */
class Solution {
    // 2d array to represent direction
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // helper function to perform dfs
    private int dfs(int[][] matrix, int[][] dp, int row, int col) {
        // if this cell already calculated -> return value
        if (dp[row][col] != 0)
            return dp[row][col];

        // track current distance, start at 1
        int longest = 1;

        // iterate through directions
        for (int[] dir : directions) {
            // get next row & cell to explore
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // if this cell out of bounds -> skip it
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length)
                continue;

            // if next cell less than neighbor -> skip it
            if (matrix[newRow][newCol] <= matrix[row][col])
                continue;

            // update longest to max of itself or future dfs calls
            longest = Math.max(longest, 1 + dfs(matrix, dp, newRow, newCol));
        }

        // update dp states
        dp[row][col] = longest;

        // return longest
        return longest;
    }

    public int longestIncreasingPath(int[][] matrix) {
        // get # of rows & cols
        int rows = matrix.length;
        int cols = matrix[0].length;

        // create 2d dp array m x n
        int[][] dp = new int[rows][cols];

        // track longest distance, start at 0
        int longest = 0;

        // iterate board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // update longest
                longest = Math.max(longest, dfs(matrix, dp, r, c));
            }
        }

        // return longest
        return longest;
    }
}
