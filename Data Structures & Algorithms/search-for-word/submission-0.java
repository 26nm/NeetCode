class Solution {
    // helper function to backtrack recursively
    private boolean dfs(char[][] board,
                        String word,
                        int r,
                        int c,
                        int index) {
        // entire word matched
        if(index == word.length()) return true;

        // out of bounds
        if(r < 0 ||
            c < 0 ||
            r >= board.length ||
            c >= board[0].length) return false;

        // current cell does not match word needed
        if(board[r][c] != word.charAt(index)) return false;

        // mark current cell as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // go up, down, left, right
        boolean found = 
            dfs(board, word, r + 1, c, index + 1) ||
            dfs(board, word, r - 1, c, index + 1) ||
            dfs(board, word, r, c + 1, index + 1) ||
            dfs(board, word, r, c - 1, index + 1);

        // restore current cell
        board[r][c] = temp;

        // return whether the word was found
        return found;

    }

    // main function
    public boolean exist(char[][] board, String word) {
        // track # of rows and columns
        int rows = board.length;
        int cols = board[0].length;

        // traverse the board
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                // try to word search from current cell
                if(dfs(board, word, r, c, 0)) return true;
            }
        }

        // word not found
        return false;
    }
}
