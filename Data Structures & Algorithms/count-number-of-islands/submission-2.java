/**
* given a 2D grid grid where '1' is land and '0' is water, count and return
* # of islands on the board
* -island formed by connecting adjacent land horizontally or vertically
* -each island surrounded with water
*
* to solve this question, we can consider flood fill approach:
* 1. track # of islands found, start with 0
*
* 2. traverse board:
*    -if we encounter land -> count as an island
*    -use DFS to flood nearby land cells until we reach water
*
* 3. return # of islands counted
*/
class Solution {
    // helper function to flood nearby land
    private void dfs(char[][] grid, int row, int col) {
        // out of bounds or no more land cells left
        if(row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == '0') return;

        // flood current cell
        grid[row][col] = '0';
        
        // flood nearby land cells
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    // main function
    public int numIslands(char[][] grid) {
        // count # of islands, start at 0
        int islands = 0;

        // traverse board
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // if we encounter land -> we hit an island
                if(grid[row][col] == '1') {
                    // increment island count
                    islands++;

                    // flood nearby land cells
                    dfs(grid, row, col);
                }
            }
        }

        // return number of islands encountered
        return islands;
    }
}
