class Solution {
    // helper function to perform dfs
    private void dfs(int[][] heights,
                        int row,
                        int col,
                        Set<String> visited,
                        int previousHeight) {
        // stop if out of bounds
        if(row < 0 ||
            col < 0 ||
            row >= heights.length ||
            col >= heights[0].length) return;

        // create key to mark cell as visited
        String key = row + "," + col;

        // stop if this cell visited or if not high enough
        if(visited.contains(key) ||
            heights[row][col] < previousHeight) return;

        // mark cell as visited
        visited.add(key);

        // recurse from 4 directions
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // get # of rows & cols
        int rows = heights.length;
        int cols = heights[0].length;

        // create sets to track whether oceans are reachable
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        // run dfs from top row in Pacific, bottom in Atlantic
        for(int col = 0; col < cols; col++) {
            // top row in Pacific
            dfs(heights, 0, col, pacific, heights[0][col]);

            // bottom row in Atlantic
            dfs(heights, rows - 1, col, atlantic, heights[rows - 1][col]);
        }

        // run dfs from left column in Pacific, right in Atlantic
        for(int row = 0; row < rows; row++) {
            // left column in Pacific
            dfs(heights, row, 0, pacific, heights[row][0]);

            // right column in Atlantic
            dfs(heights, row, cols - 1, atlantic, heights[row][cols - 1]);
        }

        // create list to hold result
        List<List<Integer>> result = new ArrayList<>();

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // make key for current cell
                String key = row + "," + col;

                // if both oceans contain this key -> add to result
                if(pacific.contains(key) &&
                    atlantic.contains(key)) {
                        result.add(Arrays.asList(row, col));
                }
            }
        }

        // return resulting list
        return result;
    }
}
