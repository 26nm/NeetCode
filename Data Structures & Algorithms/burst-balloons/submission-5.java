/**
* you are given an array of integers nums of size n
*
* ith element represents balloon with an integer value of nums[i]
* -you must burst all balloons
*
* if you burst ith balloon, you will receive
* nums[i-1] x nums[i] x nums[i+1] coins
*
* if (i-1) or (i+1) goes out of bounds, assume 
* out-of-bounds value is 1
*
* return max # of coins you can receive from bursting all balloons
*
* to solve this question, we can implement following algorithm:
*
* 1. get length of input array
*
* 2. create int array to hold balloons, set size to n+2
*    -set 1st and last elems to 1 (set boundaries)
*
* 3. iterate through nums from 1 to n:
*    -try every balloon as the last to burst
*
* 4. create 2d dp array of size (n+2) x (n+2)
*
* 5. iterate through each interval, from 1 to n:
*    -iterate from the left interval
*    -iterate from the right interval
*    -iterate from interval containing last balloon
*    -compute # of coins received
*    -update dp array
*
* 6. return result for entire interval
*/
class Solution {
    public int maxCoins(int[] nums) {
        // get length of input array
        int n = nums.length;

        // create int array to hold balloons, size n+2
        int[] balloons = new int[n + 2];

        // set 1st and last elems to 1
        balloons[0] = 1;
        balloons[n + 1] = 1;

        // try every balloon as the last to burst
        for(int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // create 2d dp int array of size (n+2) x (n+2)
        int[][] dp = new int[n + 2][n + 2];

        // iterate over each interval, from 1 to n
        for(int len = 1; len <= n; len++) {
            // iterate from the left interval
            for(int left = 1; left <= n - len + 1; left++) {
                // calc right endpoint as left + len -1
                int right = left + len - 1;

                // iterate from interval containing last balloon
                for(int last = left; last <= right; last++) {
                    // calc # of coins received from bursting
                    int coins = balloons[left - 1]
                        * balloons[last]
                        * balloons[right + 1]
                        + dp[left][last - 1]
                        + dp[last + 1][right];

                    // update dp
                    dp[left][right] = Math.max(
                        dp[left][right],
                        coins
                    );
                }
            }
        }

        // return result for entire interval
        return dp[1][n];
    }
}
