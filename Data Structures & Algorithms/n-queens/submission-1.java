/**
* n-queens puzzle is problem of placing n queens on n x n chessboard such that
* no two queens can attack each other
* -queens can attack horizontally, vertically, and diagonally
* -given integer n, return all distinct solutions to n-queens puzzle
* -'Q' indicates queen and '.' indicates empty space
*
* to solve this question, we can consider the following algorithm:
* 1. if # of rows matches n -> save board configuration
*
* 2. traverse each column:
*    -if current position vulnerable -> skip
*    -choose current position to place queen
*    -mark current space with 'Q'
*    -explore future possibilities
*    -mark empty spaces
*    -undo queen placement
*
* 3. return resulting list
*/
class Solution {
    // helper function to place queens
    private void backtrack(
        int row,
        int n,
        char[][] board,
        Set<Integer> cols,
        Set<Integer> positiveDiag,
        Set<Integer> negativeDiag,
        List<List<String>> result
    ) {
        // # of rows matches n -> all queens placed
        if(row == n) {
            // create list to hold solution
            List<String> solution = new ArrayList<>();

            // save board configuration, row by row
            for(char[] r : board) {
                // add each row to solution
                solution.add(new String(r));
            }

            // add solution to result
            result.add(solution);

            // stop
            return;
        }

        // traverse each column
        for(int col = 0; col < n; col++) {
            // if current position vulnerable -> skip
            if(cols.contains(col) ||
                positiveDiag.contains(row + col) ||
                negativeDiag.contains(row - col)) continue;

            // choose current spot to place queen
            cols.add(col);
            positiveDiag.add(row + col);
            negativeDiag.add(row - col);
            board[row][col] = 'Q';

            // explore future possibilities
            backtrack(
                row + 1,
                n,
                board,
                cols,
                positiveDiag,
                negativeDiag,
                result
            );

            // mark empty spaces
            board[row][col] = '.';

            // undo queen placement
            cols.remove(col);
            positiveDiag.remove(row + col);
            negativeDiag.remove(row - col);
        }

    }
    // main function
    public List<List<String>> solveNQueens(int n) {
        // create list to hold solution
        List<List<String>> result = new ArrayList<>();

        // track each column and diagonal
        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiag = new HashSet<>();
        Set<Integer> negativeDiag = new HashSet<>();

        // create n x n board
        char[][] board = new char[n][n];

        // fill board with data
        for(int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        // call helper function
        backtrack(0, n, board, cols, positiveDiag, negativeDiag, result);

        // return resulting list
        return result;
    }
}
