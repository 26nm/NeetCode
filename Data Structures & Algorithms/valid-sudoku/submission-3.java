class Solution {
    /**
    * we are given 9x9 matrix representing sudoku board
    *
    * board is valid if and only if:
    * 1. all rows contains 1-9 (no dupe)
    * 2. all columns contains 1-9 (no dupe)
    * 3. each sub-box (3x3 space) contains 1-9 (no dupe)
    *
    * if all these conditions are met, board is valid (return true)
    *
    * otherwise, return false
    *
    * to solve this, we can:
    * 1. create HashSet arrays to track row, column, box
    *    -for each one, put a HashSet to track individual spaces
    *    -within each
    *
    * 2. traverse the matrix:
    *    -if current char is '.', skip over
    *    -calculate sub-box index (use (i / 3) * 3 + (j / 3))
    *    -if row, column, or box contains a dupe, return false
    *    -otherwise add current char to each set
    *
    * 3. return true
    */ 
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // add sets to each
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // traverse board
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if(curr == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3);

                if(rows[i].contains(curr) || columns[j].contains(curr) || boxes[boxIndex].contains(curr)) {
                    return false;
                }

                rows[i].add(curr);
                columns[j].add(curr);
                boxes[boxIndex].add(curr);
            }
        }

        return true;
    }
}
