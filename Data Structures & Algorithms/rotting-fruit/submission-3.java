/**
* we are given 2D matrix grid, in which cell can have 1 of 3 values:
* 1. 0 - empty cell
* 2. 1 - fresh fruit
* 3. 2 - rotten fruit
*
* every minute, if fresh fruit is horizontally or vertically adjacent
* to rotten fruit, it rots
*
* return minimum # of minutes to rot all fruit, or -1 if impossible with
* current board
*
* to solve this question, we can consider following algo:
* 1. get # of rows and cols
*
* 2. track # of fresh fruit, start with 0
*
* 3. create queue to process all rotten fruit
*
* 4. traverse board:
*    -if we encounter rotten -> add to queue
*    -if we encounter fresh -> increment fresh fruit
*
* 5. track # of fresh fruit -> start with 0
*   
* 6. create 2D array to represent directions
*
* 7. process all rotten fruit cells while # of fresh is pos:
*    -get # of rotten fruit
*    -iterate # of rotten times:
*     -get current cell with rotting fruit
*     -get current row & col
*     -iterate through directions:
*      -calc new row & col to explore
*      -if these are invalid -> skip
*      -rot this cell
*      -decrease # of fresh fruit
*      -add these cells to queue
*    
* 8. increment time elapsed
*
* 9. if all fruits rotten -> return time elapsed -> -1 otherwise 
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        // get # of rows & cols
        int rows = grid.length;
        int cols = grid[0].length;

        // track # of fresh fruit, start with 0
        int fresh = 0;

        // create queue to process cells with rotting fruit
        Queue<int[]> rotten = new ArrayDeque<>();

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if we encounter rotting fruit -> add to queue
                if(grid[row][col] == 2) {
                    rotten.offer(new int[]{row, col});
                }

                // if we encounter fresh fruit -> increment fresh
                if(grid[row][col] == 1) fresh++;
            }
        }

        // track minutes elapsed, start with 0
        int minutes = 0;

        // create 2D array to store direction
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // rot nearby fruit while we have fresh fruit
        while(!rotten.isEmpty() && fresh > 0) {
            // get # of rotten fruit
            int numRotten = rotten.size();

            // rot fresh fruit adjacent to each rotten
            for(int i = 0; i < numRotten; i++) {
                // get current cell with rotting fruit
                int[] current = rotten.poll();

                // get current row & col
                int row = current[0];
                int col = current[1];

                // rot in all 4 directions
                for(int[] dir : directions) {
                    // get new row & col to rot
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // skip if this cell invalid
                    if(newRow < 0 ||
                        newCol < 0 ||
                        newRow >= rows ||
                        newCol >= cols ||
                        grid[newRow][newCol] != 1) continue;

                    // rot current cell
                    grid[newRow][newCol] = 2;

                    // decrease # of fresh fruit
                    fresh--;

                    // add new cell to explore to queue
                    rotten.offer(new int[]{newRow, newCol});
                }
            }

            // increment time elapsed
            minutes++;
        }

        // return time elapsed if all fruit rotten, -1 otherwise
        return fresh == 0 ? minutes : -1;
    }
}
