/**
* there is m x n grid where you are allowed to move either down or right
* at any point in time
*
* given two integers m and n, return number of possible unique paths that
* can be taken from top-left corner of grid (grid[0][0]) to bottom-right
* corner (grid[m - 1][n - 1])
*
* to solve this question, we can implement following algo:
* 
* 1. create dp array of size n
*
* 2. iterate rows from m-2 to 0:
*    -iterate cols from n-2 to 0:
*     -update cols in dp to itself + next cell to right
*
* 3. return 1st element in dp
*/
class Solution {
    public int uniquePaths(int m, int n) {
        // create dp array of size n
        int[] dp = new int[n];

        // fill array with 1s
        Arrays.fill(dp, 1);

        // iterate rows from m-2 to 0
        for(int row = m - 2; row >= 0; row--) {
            // iterate cols from n-2 to 0
            for(int col = n - 2; col >= 0; col--) {
                // update col in dp to itself + next cell 
                dp[col] += dp[col + 1];
            }
        }

        // return 1st element in dp
        return dp[0];
    }
}
