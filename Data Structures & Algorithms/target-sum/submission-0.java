class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // track total, start with 0
        int total = 0;

        // iterate through nums, get running total
        for(int num : nums) {
            total += num;
        }

        // if abs value of target > total or target + total odd,
            // return 0
        if(Math.abs(target) > total ||
            (target + total) % 2 != 0) return 0;

        // compute subset size
        int subset = (target + total) / 2;

        // create dp array of size subset + 1
        int[] dp = new int[subset + 1];

        // set 1st elem in dp to 1
        dp[0] = 1;

        // iterate through nums
        for(int num : nums) {
            // iterate through each sum in subset
            for(int sum = subset; sum >= num; sum--) {
                // update sum in dp to itself + sum - num in dp
                dp[sum] += dp[sum - num];
            }
        }

        // return subset in dp
        return dp[subset];
    }
}
