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

        // traverse border cells on left & right
        for(int row = 0; row < rows; row++) {
            // left column
            dfs(board, row, 0);

            // right column
            dfs(board, row, cols - 1);
        }

        // traverse border cells on top & bottom
        for(int col = 0; col < cols; col++) {
            // top row
            dfs(board, 0, col);

            // bottom row
            dfs(board, rows - 1, col);
        }

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if current cell is 'O' -> capture it
                if(board[row][col] == 'O') {
                    board[row][col] = 'X';

                // if marked as safe -> revert to O
                } else if(board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}
