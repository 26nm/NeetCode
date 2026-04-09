class Solution {
    /**
    * we are given a 9x9 Sudoku board
    *
    * board is valid if:
    * 1. each row contains digits 1-9 without duplicates
    * 2. each column contains digits 1-9 without duplicates
    * 3. each sub-box (3x3 spaces) contains digits 1-9 without duplicates
    *
    * return true if all these conditions are satisfied
    * 
    * board doesn't need to be solvable or full
    *
    * input: 
    * [["1","2",".",".","3",".",".",".","."],
       ["4",".",".","5",".",".",".",".","."],
       [".","9","8",".",".",".",".",".","3"],
       ["5",".",".",".","6",".",".",".","4"],
       [".",".",".","8",".","3",".",".","5"],
       ["7",".",".",".","2",".",".",".","6"],
       [".",".",".",".",".",".","2",".","."],
       [".",".",".","4","1","9",".",".","8"],
       [".",".",".",".","8",".",".","7","9"]]
    * 
    * output: true
    *
    * we could make 3 HashSets to represent:
    * -each row
    * -each column
    * -each sub-box?
    *
    * "." represents empty spaces
    *
    * to solve this, we could:
    * 1. iterate through the board (9x9):
    *    -create HashSet for each row
    *    -create HashSet for each column
    *    -create HashSet for each sub-box
    *. 
    * 2. for each space, scan for the following:
    *    -if the space is blank ('.'), skip over it
    *    -if the space contains a value already in
    *     the set, return false
    */
    public boolean isValidSudoku(char[][] board) {
        // track each row, column, and box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // create sets for each row, column, and box to track dupes
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // traverse sudoku board
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;

                // contain within sub-boxes
                int boxIdx = (i / 3) * 3 + (j / 3);

                // check for dupes
                if(rows[i].contains(c) || cols[j].contains(c) || boxes[boxIdx].contains(c)) {
                    return false;
                }

                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIdx].add(c);
            }
        }

        return true;
    }
}
