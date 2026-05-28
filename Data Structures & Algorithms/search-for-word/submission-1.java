/**
* given a 2D grid of characters board and a string word, return true if
* word is present in grid, false otherwise
* -for word to be present it must be possible to form it with a path in
*  board with horizontal or vertical neighboring calls
* -cells may not be reused
*
* to solve this question, we can consider the following approach:
* 1. if index matches word length -> word found -> return true
*
* 2. if we're out of bounds -> return false
*
* 3. if the current cell does not match current letter -> return false
*    -temporarily mark cell as visited
*
* 4. recurse up, down, left, right
*    -unmark cell
*
* 5. return result
*/
class Solution {
    // helper function to perform dfs recursively
    private boolean dfs(char[][] board,
                        String word,
                        int r,
                        int c,
                        int index) {
        // word found
        if(index == word.length()) return true;

        // out of bounds
        if(r < 0 ||
            c < 0 ||
            r >= board.length ||
            c >= board[0].length) return false;

        // cell does not contain character we're after
        if(board[r][c] != word.charAt(index)) return false;

        // temporarily mark cell as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // recurse up, down, left, right
        boolean found = 
            dfs(board, word, r + 1, c, index + 1) ||
            dfs(board, word, r - 1, c, index + 1) ||
            dfs(board, word, r, c + 1, index + 1) ||
            dfs(board, word, r, c - 1, index + 1);

        // restore cell
        board[r][c] = temp;

        // return whether word was found
        return found;
    }

    // helper function
    public boolean exist(char[][] board, String word) {
        // track # of rows and columns
        int rows = board.length;
        int cols = board[0].length;

        // traverse board
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
