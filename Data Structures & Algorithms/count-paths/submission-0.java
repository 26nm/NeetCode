class Solution {
    public int uniquePaths(int m, int n) {
        // create dp array of size n
        int[] dp = new int[n];

        // fill array with 1s
        Arrays.fill(dp, 1);

        // iterate rows from m-2 to 0
        for(int row = m - 2; row >= 0; row--) {
            // iterate columns from n-2 to 0
            for(int col = n - 2; col >= 0; col--) {
                // update col in dp to itself + next cell
                dp[col] += dp[col + 1];
            }
        }

        // return 1st element in dp
        return dp[0];
    }
}
