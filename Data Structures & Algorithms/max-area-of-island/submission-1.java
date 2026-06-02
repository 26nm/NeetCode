/**
* we are given matrix grid where grid[i] is either 0 (water) or 1 (land)
* -an island is group of 1s connected horizontally or vertically
* -you may assume all 4 edges of grid surrounded by water
* -area of island is # of cells within island
*
* return max area of island in grid
*
* to solve this question, we can implement following algorithm:
* 1. if we out of bounds or hit water -> return 0
*
* 2. flood current cell
*
* 3. return 1 + area of neighbors
*/
class Solution {
    // helper function to perform dfs
    private int dfs(int[][] grid, int row, int col) {
        // out of bounds or hit water
        if(row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0) return 0;

        // mark current cell as water
        grid[row][col] = 0;

        // return area from neighbors
        return 1 + 
            dfs(grid, row + 1, col) +
            dfs(grid, row - 1, col) +
            dfs(grid, row, col + 1) +
            dfs(grid, row, col - 1);

    }

    // main function
    public int maxAreaOfIsland(int[][] grid) {
        // track max area, start at 0
        int maxArea = 0;

        // traverse board
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // if we hit land -> update max area
                if(grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }

        // return max area
        return maxArea;
    }
}
