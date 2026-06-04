class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // get # of rows and columns
        int rows = grid.length;
        int cols = grid[0].length;

        // create queue to process treasure cells
        Queue<int[]> queue = new ArrayDeque<>();

        // iterate through board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // if current cell is treasure -> add to queue
                if(grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // create 2D array to represent directions
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // process treasure cells until queue is empty
        while(!queue.isEmpty()) {
            // get current treasure cell
            int[] current = queue.poll();

            // get current row & col
            int row = current[0];
            int col = current[1];

            // iterate through directions
            for(int[] dir : directions) {
                // change direction
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // skip over if out of bounds or cell not land
                if(newRow < 0 ||
                    newCol < 0 ||
                    newRow >= rows ||
                    newCol >= cols ||
                    grid[newRow][newCol]
                        != Integer.MAX_VALUE) continue;

                // modify grid values as distance from land to treasure
                grid[newRow][newCol] = grid[row][col] + 1;

                // add next cell to queue
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
