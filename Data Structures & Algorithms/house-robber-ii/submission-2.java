/**
* you are given an integer array nums where nums[i] represents amount of
* money ith house has
* -houses arranged in a circle (first & last houses adjacent to each other)
* -cannot rob two adjacent houses
*
* return max amount of money you can rob without alerting police
*
* to solve this question, we can consider following algo:
* 
* rob helper:
* 1. track amount robbed from both houses, start at 0
*
* 2. iterate from left until right:
*    -get current amount as max of rob from 1st house + i in nums, rob2
*    -adjust window

* 3. return amount robbed from 2nd house
*
* main function:
* 1. if input contains only 1 house -> return that
*
* 2. recurse for following ranges:
*    0 to n-2
*    1 to n-1
*/
class Solution {
    // helper function to rob houses within range
    private int robRange(int[] nums, int left, int right) {
        // track amount robbed from both houses, start at 0
        int rob1 = 0;
        int rob2 = 0;

        // iterate until left & right meet
        for(int i = left; i <= right; i++) {
            // cal current robbery amount
            int current = Math.max(rob1 + nums[i], rob2);

            // shift window
            rob1 = rob2;
            rob2 = current;
        }

        // return amount robbed from 2nd house
        return rob2;
    }

    // main function
    public int rob(int[] nums) {
        // if input contains only 1 house -> return that
        if(nums.length == 1) return nums[0];

        // return max of robbing from both ranges
        return Math.max(
            robRange(nums, 0, nums.length - 2),
            robRange(nums, 1, nums.length - 1)
        );
    }
}
