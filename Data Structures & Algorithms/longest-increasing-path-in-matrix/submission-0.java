class Solution {
    // create 2d array for directions
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // main function
    public int longestIncreasingPath(int[][] matrix) {
        // get # of rows and cols
        int rows = matrix.length;
        int cols = matrix[0].length;

        // create dp array of size rows x cols
        int[][] dp = new int[rows][cols];

        // track longest path, start at 0
        int longest = 0;

        // iterate through board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // update longest to dfs iteration of each cell
                longest = Math.max(longest, dfs(matrix, dp, r, c));
            }
        }

        // return longest path
        return longest;
    }

    // helper function to perform dfs
    private int dfs(int[][] matrix, int[][] dp, int row, int col) {
        // if current cell already calculated -> return current cell
        if (dp[row][col] != 0)
            return dp[row][col];

        // track longest path, start at 1
        int longest = 1;

        // iterate through directions array
        for (int[] dir : directions) {
            // calc next row and col
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // if current cell out of bounds -> skip it
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length) {
                continue;
            }

            // if new cell is smaller than neighbors -> skip over it
            if (matrix[newRow][newCol] <= matrix[row][col])
                continue;

            // update longest to max of itself or dfs iteration of next cell
            longest = Math.max(longest, 1 + dfs(matrix, dp, newRow, newCol));
        }

        // update current cell with longest
        dp[row][col] = longest;

        // return longest
        return longest;
    }
}
