/**
* we are given integer array nums where nums[i] represents amount of money
* ith house has
* -houses arranged in straight line
* -i.e., ith house neighbors (i-1)th and (i+1)th houses
* -cannot rob two adjacent houses due to security system
*
* return max amount of money you can rob without alerting police
*
* to solve this question, we can consider following algo:
* 1. track amounts from both houses, start with 0
*
* 2. iterate through nums:
*    -calc current as max of 1st house + its money, and 2nd house
*    -shift window
*
* 3. return robbery amount from 2nd house
*/
class Solution {
    public int rob(int[] nums) {
        // track robbery amount from both houses, start at 0
        int rob1 = 0;
        int rob2 = 0;

        // iterate through houses
        for(int money : nums) {
            // calc current as biggest from 1st house + its value & 2nd house
            int current = Math.max(rob1 + money, rob2);

            // shift window
            rob1 = rob2;
            rob2 = current;
        }

        // return amount from 2nd house
        return rob2;
    }
}
