class Solution {
    public int orangesRotting(int[][] grid) {
        // get # of rows and cols
        int rows = grid.length;
        int cols = grid[0].length;

        // create queue to process cells with rotting fruit
        Queue<int[]> rotten = new ArrayDeque<>();

        // track # of fresh fruits, start with 0
        int fresh = 0;

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if we encounter rotting fruit -> add to queue
                if(grid[row][col] == 2) {
                    rotten.offer(new int[]{row, col});
                }

                // if we encounter fresh fruit -> increment # of fresh
                if(grid[row][col] == 1) fresh++;
            }
        }

        // track minutes elapsed, start with 0
        int minutes = 0;

        // create 2D array to represent direction
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // process all cells with rotten fruit
        while(!rotten.isEmpty() && fresh > 0) {
            // get # of rotten fruits
            int numRotten = rotten.size();

            // iterate # of rotten fruits times
            for(int i = 0; i < numRotten; i++) {
                // get current cell with rotting fruit
                int[] current = rotten.poll();

                // get current row & col
                int row = current[0];
                int col = current[1];

                // iterate through directions
                for(int[] dir : directions) {
                    // calc next row & col
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // skip new cell if out of bounds or not fresh
                    if(newRow < 0 ||
                        newCol < 0 ||
                        newRow >= rows ||
                        newCol >= cols ||
                        grid[newRow][newCol] != 1) continue;

                    // rot current cell
                    grid[newRow][newCol] = 2;

                    // decrease # of fresh fruit
                    fresh--;

                    // add next cell to explore to queue
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
