/**
 * you are given an array of integers nums of size n
 *
 * ith element represents balloon with integer value of nums[i]
 * -you must burst all balloons
 *
 * if you burst ith balloon, you will receive nums[i-1] x nums[i]
 * x nums[i+1] coins
 *
 * if (i-1) or (i+1) goes out of bounds, assume out of bounds value
 * is 1
 *
 * return max # of coins you can receive by bursting all balloons
 *
 * to solve this question, we can implement following algorithm:
 *
 * 1. get length of input array
 *
 * 2. create int array to hold balloons (size n+2)
 *    -set 1st and last elems to 1
 *
 * 3. iterate 0 to length of input:
 *    -try every balloon as last to burst
 *
 * 4. create 2d dp int array of size (n+2) x (n+2)
 *
 * 5. iterate each interval from 1 to n:
 *    -iterate through left interval
 *    -iterate through right interval
 *    -iterate through interval containing last balloon
 *    -compute coins from bursting balloons from each interval
 *    -update dp states
 *
 * 6. return results for entire interval
 */
class Solution {
    public int maxCoins(int[] nums) {
        // get length of input array
        int n = nums.length;

        // create int array to hold balloons, size (n+2)
        int[] balloons = new int[n + 2];

        // set 1st and last elems to 1
        balloons[0] = 1;
        balloons[n + 1] = 1;

        // try every balloon as last to burst
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // create 2d dp int array of size (n+2) x (n+2)
        int[][] dp = new int[n + 2][n + 2];

        // iterate through each interval from 1 to n
        for (int len = 1; len <= n; len++) {
            // iterate from left interval
            for (int left = 1; left <= n - len + 1; left++) {
                // calc right endpoint
                int right = left + len - 1;

                // iterate from interval containing last balloon
                for (int last = left; last <= right; last++) {
                // compute # of coins from bursting balloons
                    // in each interval
                    int coins = balloons[left - 1] * balloons[last] * balloons[right + 1]
                        + dp[left][last - 1] + dp[last + 1][right];

                    // update dp states
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        // return result for entire interval
        return dp[1][n];
    }
}
