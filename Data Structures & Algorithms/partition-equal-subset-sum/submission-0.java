class Solution {
    public boolean canPartition(int[] nums) {
        // track total sum, start at 0
        int total = 0;

        // iterate through nums
        for(int num : nums) {
            // get running total of all #s
            total += num;
        }

        // if total is odd -> return false
        if(total % 2 != 0) return false;

        // calculate target
        int target = total / 2;

        // create boolean dp array of size target + 1
        boolean[] dp = new boolean[target + 1];

        // set 1st element to true
        dp[0] = true;

        // iterate through nums
        for(int num : nums) {
            // iterate through each sum up to current num
            for(int sum = target; sum >= num; sum--) {
                // set sum in dp to its current value or
                    // whether its previous sum can be made
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        // return value of target in dp
        return dp[target];
    }
}
