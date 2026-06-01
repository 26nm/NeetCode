class Solution {
    // helper function to sink islands
    private void dfs(char[][] grid, int row, int col) {
        // out of bounds or no more land left
        if(row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == '0') return;

        // mark current space as water
        grid[row][col] = '0';

        // flood adjacent cells
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    // main function
    public int numIslands(char[][] grid) {
        // count # of islands, start with 0
        int islands = 0;

        // traverse board
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // if land encountered -> we encountered an island
                if(grid[row][col] == '1') {
                    // increment island count
                    islands++;
                    
                    // flood adjacent cells
                    dfs(grid, row, col);
                }
            }
        }

        // return # of islands encountered
        return islands;
    }
}
