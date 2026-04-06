class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, minutes = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});

                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for(int[] d : directions) {
                    int nr = curr[0] + d[0], nc = curr[1] + d[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
