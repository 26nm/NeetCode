/**
* we are given 2D matrix grid, where each cell can have 1 of 3 values:
* 1. 0 - empty cell
* 2. 1 - fresh fruit
* 3. 2 - rotten fruit
*
* every minute, if fresh fruit is horizontally or vertically adjacent to
* rotten fruit, it also rots
*
* return minimum number of minutes to rot all fruit, or -1 if impossible
* with current board
*
* to solve this question, we can consider following algo:
* 1. get current # of rows & cols
*
* 2. track # of fresh fruit, start with 0
*
* 3. create queue to process cells with rotting fruit
*
* 4. traverse board:
*    -if cell contains rotting fruit -> add to queue
*    -if cell contains fresh fruit -> increment fresh fruit
*
* 5. track time elapsed (in minutes), start with 0
*
* 6. create 2D array to represent directions
*
* 7. process all cells with rotting fruit while # of fresh fruits
*    is positive:
*    -get current cell with rotting fruit
*    -get current row & col
*    -get # of rotten fruit
*    -iterate # of rotten fruit times:
*     -iterate through directions:
*      -get new row & col to rot
*      -skip this new cell if out of bounds or fresh
*      -rot this cell
*      -add this cell to queue
*    -increment minutes passed
*
* 8. return # of mins elapsed if all fruits rot, -1 otherwise
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        // get # of rows & cols
        int rows = grid.length;
        int cols = grid[0].length;

        // track # of fresh fruit, start with 0
        int fresh = 0;

        // create queue to hold cells with rotten fruit
        Queue<int[]> rotten = new ArrayDeque<>();

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if cell has rotten -> add to queue
                if(grid[row][col] == 2) {
                    rotten.offer(new int[]{row, col});
                }

                // if cell has fresh -> increment # of fresh fruit
                if(grid[row][col] == 1) fresh++;
            }
        }

        // track time elapsed start with 0
        int minutes = 0;

        // create 2D array to represent direction
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // process all rotten fruit while we have positive # of fresh fruit
        while(!rotten.isEmpty() && fresh > 0) {
            // get # of rotten fruit
            int numRotten = rotten.size();

            // iterate # of rotten fruit times
            for(int i = 0; i < numRotten; i++) {
                // get current cell
                int[] current = rotten.poll();

                // get current row & col
                int row = current[0];
                int col = current[1];

                // iterate through directions
                for(int[] dir : directions) {
                    // find new row & col to rot
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // if new cell invalid -> skip
                    if(newRow < 0 ||
                        newCol < 0 ||
                        newRow >= rows ||
                        newCol >= cols ||
                        grid[newRow][newCol] != 1) continue;

                    // rot current cell
                    grid[newRow][newCol] = 2;

                    fresh--;

                    rotten.offer(new int[]{newRow, newCol});
                }
            }

            // increment time elapsed
            minutes++;
        }

        // return if all fruit rotted
        return fresh == 0 ? minutes : -1;
    }
}
