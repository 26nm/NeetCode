/**
* we are given matrix grid where grid[i] is either 0 (water) or 1 (land)
* -an island defined as group of 1s connected horizontally or vertically
* -area of island defined as # of cells within island
*
* return max area of island in grid
* -if none exist -> return 0
*
* to solve this question, we should consider following approach:
* 1. track max area so far, start with 0
*
* 2. traverse through board:
*    -if we hit land -> perform DFS from this cell
*    -calculate area
*    -update max area seen so far
*
* 3. return max area
*/
class Solution {
    // helper function to calculate area with dfs
    private int dfs(int[][] grid, int row, int col) {
        // out of bounds or no more land left
        if(row < 0 || 
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0) return 0;

        // flood land cells and count them
        grid[row][col] = 0;

        // count nearby land cells
        return 1 + dfs(grid, row + 1, col)
                    + dfs(grid, row - 1, col)
                    + dfs(grid, row, col + 1)
                    + dfs(grid, row, col - 1);    
    }

    // main function
    public int maxAreaOfIsland(int[][] grid) {
        // track max area so far, start at 0
        int maxArea = 0;

        // traverse board
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // calculate area if we hit land
                if(grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }

        // return max area
        return maxArea;
    }
}
