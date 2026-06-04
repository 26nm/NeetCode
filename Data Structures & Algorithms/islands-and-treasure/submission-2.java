/**
* we are given (m x n) 2D grip initialized with 3 possible values:
* 1. -1: water cell (cannot traverse)
* 2. 0: treasure
* 3. inf: land 
*
* fill each land cell with distance to nearest treasure chest
* -if land cannot reach a chest -> leave its value as inf
* -you can explore up, down, left, right
*
* to solve this question, we can consider following algo:
* 1. get # of rows and cols
*
* 2. create queue to process cells with treasure chests
*
* 3. traverse board:
*    -add cells containing treasure to queue
*
* 4. make a 2D array representing directions
*
* 5. process each treasure cell in queue:
*    -get current cell (row & col)
*    -iterate through directions array:
*     -calc next spot to explore
*     -if this spot out of bounds or not land -> skip
*     -modify this new spot to be distance from land to treasure
*     -add this new spot to queue
*/
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // get # of rows and cols
        int rows = grid.length;
        int cols = grid[0].length;

        // create queue to process treasure cells
        Queue<int[]> treasure = new ArrayDeque<>();

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if current cell is treasure -> add to queue
                if(grid[row][col] == 0) {
                    treasure.offer(new int[]{row, col});
                }
            }
        }

        // create 2D array to represent direction
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // process each cell containing treasure
        while(!treasure.isEmpty()) {
            // get current treasure cell
            int[] current = treasure.poll();

            // get current row & col
            int row = current[0];
            int col = current[1];

            // explore each direction
            for(int[] direction : directions) {
                // find next row & col to explore
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // check if this spot is out of bounds or not land
                if(newRow < 0 ||
                    newCol < 0 ||
                    newRow >= rows ||
                    newCol >= cols ||
                    grid[newRow][newCol]
                        != Integer.MAX_VALUE) continue;

                // set this spot's values to be distance from land to treasure
                grid[newRow][newCol] = grid[row][col] + 1;

                // add next spot to expore to queue
                treasure.offer(new int[]{newRow, newCol});
            }
        }
    }
}
