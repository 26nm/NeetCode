/***
* you are given an array of positive integers nums
*
* return true if you can partition array into two subsets
*
* to solve this question, we can consider following algorithm:
*
* 1. track total sum of set, start at 0
*
* 2.
*
* 2. create dp array of size target + 1
*
* 2. iterate through nums:
*    -get running total of set
*
* 3. if total is odd -> return false
*
* 4. iterate through nums once more:
*    -iterate through every sum, starting at target til num:
*     -set num in dp to its value or sum - num in dp
*
* 5. return value of target in dp
*/
class Solution {
    public boolean canPartition(int[] nums) {
        // track set total, start at 0
        int total = 0;

        // iterate through nums and get running total
        for(int num : nums) {
            total += num;
        }
        
        // if total odd -> return false
        if(total % 2 != 0) return false;

        // calc target value as half of total sum
        int target = total / 2;

        // create boolean dp array of size target + 1
        boolean[] dp = new boolean[target + 1];

        // set 1st element in dp to true
        dp[0] = true;

        // iterate through nums
        for(int num : nums) {
            // iterate through each sum up to current num
            for(int sum = target; sum >= num; sum--) {
                // update dp[sum]
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        // return value of target in dp
        return dp[target];
    }
}
