/**
* we are given rectangular island heights where heights[r][c] represents
* height above sea level of cell at coordinate (r,c)
*
* islandd border pacific ocean from top & left, atlantic bottom & right
*
* water can flow in 4 directions from cell to neighboring cell with height
* equal or lower
*
* find all cells where water can flow from that cell to both oceans
* -return as 2D list
*
* to solve this question, we can consider following algo:
* 1. get # of rows & cols
*
* 2. create 2 sets to represent visited cells in both oceans
*
* 3. perform dfs in top row pacific, bottom row atlantic
*    -perform dfs in left column pacific, right column atlantic
* 
* 4. create list to hold result
*
* 5. traverse board:
*    -create key for current cell
*    -if cell can be visited from both oceans -> add row and col to result
*
* 6. return resulting list
*/
class Solution {
    // helper function to perform dfs
    private void dfs(int[][] heights,
                        int row,
                        int col,
                        Set<String> visited,
                        int prevHeight) {
        // if cell out of bounds stop
        if(row < 0 ||
            col < 0 ||
            row >= heights.length ||
            col >= heights[0].length) return;

        // create key to mark cell as visited
        String key = row + "," + col;

        // if this cell visited or not high enough -> stop
        if(visited.contains(key) ||
            heights[row][col] < prevHeight) return;

        // mark cell as visited
        visited.add(key);

        // recurse from 4 directions
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }

    // main function
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // get # of rows & cols
        int rows = heights.length;
        int cols = heights[0].length;

        // create sets to track visited cells in both oceans
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        // perform dfs for top row in pacific, bottom row in atlantic
        for(int col = 0; col < cols; col++) {
            // top row pacific
            dfs(heights, 0, col, pacific, heights[0][col]);

            // bottom row atlantic
            dfs(heights, rows - 1, col, atlantic, heights[rows - 1][col]);
        }

        // perform dfs for left column in pacific, right column in atlantic
        for(int row = 0; row < rows; row++) {
            // left column pacific
            dfs(heights, row, 0, pacific, heights[row][0]);

            // right column atlantic
            dfs(heights, row, cols - 1, atlantic, heights[row][cols - 1]);
        }

        // create list to hold result
        List<List<Integer>> result = new ArrayList<>();

        // traverse board
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // create key for current cell
                String key = row + "," + col;

                // if key present in both oceans -> add row col pair to result
                if(pacific.contains(key) &&
                    atlantic.contains(key)) {
                        // add row col pair to result
                        result.add(Arrays.asList(row, col));
                }
            }
        }

        // return resulting list
        return result;
    }
}
