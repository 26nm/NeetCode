/**
* we are given a (m x n) 2D grid initialized with 3 possible values:
* 1. -1: water cell (can't be traversed)
* 2. 0: treasure
* 3. INF: land cell
*
* fill each land cell with distance to nearest treasure chest
* -if land cell cannot reach treasure, keep value as inf
* -you can traverse up, down, left, right
*
* to solve this question, we can consider following algo:
* 1. get # of rows and cols
*
* 2. create queue to process treasure cells
*
* 3. iterate through board:
*    -if we hit treasure -> add cell to queue
*
* 4. iterate until queue empty:
*    -get current row & col
*    -make an array representing direction
*    -calc new row & col
*    -iterate through directions:
*     -if out of bounds or cell not land -> skip over
*     -modify grid values with distance from land to treasure
*     -add next cell to queue
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
                // if we hit treasure cell -> add to queue
                if(grid[row][col] == 0) {
                    treasure.offer(new int[]{row,col});
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

        // iterate until queue is empty
        while(!treasure.isEmpty()) {
            // get current treasure cell
            int[] current = treasure.poll();

            // get current row & col
            int row = current[0];
            int col = current[1];

            // change direction
            for(int[] dir : directions) {
                // get new row & col
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // if out of bounds or not land -> skip over
                if(newRow < 0 ||
                    newCol < 0 ||
                    newRow >= rows ||
                    newCol >= cols ||
                    grid[newRow][newCol]
                        != Integer.MAX_VALUE) continue;

                // modify grid value with distance from land to treasure
                grid[newRow][newCol] = grid[row][col] + 1;

                // add next cell to queue
                treasure.offer(new int[]{newRow, newCol});
            }
        }
    }
}
