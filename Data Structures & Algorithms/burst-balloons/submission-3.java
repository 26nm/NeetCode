class Solution {
    public int maxCoins(int[] nums) {
        // get length of input array
        int n = nums.length;

        // create array to hold balloons of size n+2
        int[] balloons = new int[n + 2];

        // set 1st and last elements to 1
        balloons[0] = 1;
        balloons[n + 1] = 1;

        // try every balloon as the last balloon to burst
        for(int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // create 2d dp array of size (n+2) x (n+2)
        int[][] dp = new int[n + 2][n + 2];

        // iterate over interval lengths from 1 to n
        for(int len = 1; len <= n; len++) {
            // iterate over intervals on the right
            for(int left = 1; left <= n - len + 1; left++) {
                // calc right endpoint as left + len - 1
                int right = left + len - 1;

                // iterate over intervals containing last balloon
                for(int last = left; last <= right; last++) {
                    // compute # of coins from left interval,
                        // right interval, and bursting last
                        // balloon
                    int coins = balloons[left - 1]
                        * balloons[last]
                        * balloons[right + 1]
                        + dp[left][last - 1]
                        + dp[last + 1][right];

                    // update left & right in dp to max of 
                        // its current value or coin amount
                        // computed
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        // return answer for entire interval
        return dp[1][n];
    }
}
