/**
* you are given an array of integers nums and an integer target
*
* for each num in array, you can choose to either add or subtract it
* to a total sum
* -e.g., if nums = [1,2], one possible sum would be "+1-2=-1"
* -if nums = [1,1], there are 2 different ways to sum input numbers to 0:
*  -"+1-1"
*  ="-1+1"
*
* return number of different ways to build expression such that total sum
* equals target
*
* to solve this question, we can implement following algorithm:
* 1. track total value of set, start at 0
*    -update this value to set's running total
*
* 2. if abs value of target bigger than set total or sum of total + target
*    odd, return 0
*    -otherwise, calculate subset size as (total + target) / 2
*
* 3. create dp array of size subset + 1
*    -set 1st element in dp to 1
*
* 4. iterate through each num:
*    -iterate through each sum starting at subset up to num:
*     -update sum in dp to itself + sum - num in dp
*
* 5. return amount in dp
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // track total value of set, start at 0
        int total = 0;

        // get running total of set
        for(int num : nums) {
            total += num;
        }

        // if abs value of target bigger than set total or 
            // sum of target and total odd -> return 0
        if(Math.abs(target) > total ||
            (total + target) % 2 != 0) return 0;

        // calculate subset size
        int subset = (total + target) / 2;

        // create dp array of size subset + 1
        int[] dp = new int[subset + 1];

        // set 1st elem in dp to 1
        dp[0] = 1;

        // iterate through each num
        for(int num : nums) {
            // iterate through each sum, starting from end of subset
            for(int sum = subset; sum >= num; sum--) {
                // update sum in dp to itself + sum - num in dp
                dp[sum] += dp[sum - num];
            }
        }

        // return subset in dp
        return dp[subset];
    }
}
