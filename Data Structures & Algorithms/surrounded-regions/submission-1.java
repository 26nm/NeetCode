/**
* we are given an m x n matrix board containing letters 'X' and 'O'
*
* capture regions that are surrounded:
* -connect: a cell is connected to adjacent cells horizontally or vertically
* -region: to form a region, connect every 'O' cell
* -surround: a region is surrounded if none of 'O' cells are on edge of board
*
* to capture surrounded region, replace all Os with Xs in-place within original board
*
* to solve this question, we can consider following algorithm:
* 1. if out of bounds or cell not 'O' -> stop
*
* 2. mark cell as safe (temporarily)
*
* 3. recurse from 4 directions
*
* main function:
* 1. get # of rows & cols
*
* 2. perform dfs on border cells on left/right columns
*    -perform dfs on border cells on top/bottom rows
*
* 3. traverse board again:
*    -if we encounter 'O' -> capture (change to 'X')
*    -otherwise change to 'O'
*/
class Solution {
    // helper function to perform dfs
    private void dfs(char[][] board, int row, int col) {
        // if out of bounds or cell not 'O' -> stop
        if(row < 0 ||
            col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != 'O') return;

        // temporarily mark cell as safe
        board[row][col] = 'T';

        // recurse from 4 directions
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    // main function
    public void solve(char[][] board) {
        // get # of rows & cols
        int rows = board.length;
        int cols = board[0].length;

        // perform dfs on border cells in left/right columns
        for(int row = 0; row < rows; row++) {
            // left column
            dfs(board, row, 0);

            // right column
            dfs(board, row, cols - 1);
        }

        // perform dfs on border cells in top/bottom rows
        for(int col = 0; col < cols; col++) {
            // top row
            dfs(board, 0, col);

            // bottom row
            dfs(board, rows - 1, col);
        }

        // traverse board again
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if current cell is 'O' -> capture it
                if(board[row][col] == 'O') {
                    board[row][col] = 'X';

                // if cell marked as temporarily safe -> revert
                } else if(board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}
