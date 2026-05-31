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

            // traverse through board
            for(char[] r : board) {
                // add each cell to solution
                solution.add(new String(r));
            }

            // add solution to result
            result.add(solution);

            // stop
            return;
        }

        // navigate each column
        for(int col = 0; col < n; col++) {
            // if queen exists in vulnerable spot -> skip
            if(cols.contains(col) ||
                positiveDiag.contains(row + col) ||
                negativeDiag.contains(row - col)) continue;

            // place queen
            cols.add(col);
            positiveDiag.add(row + col);
            negativeDiag.add(row - col);

            // choose current spot to place queen
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
        // create list to hold result
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
        backtrack(
            0,
            n,
            board,
            cols,
            positiveDiag,
            negativeDiag,
            result
        );

        // return resulting list
        return result;
    }
}
