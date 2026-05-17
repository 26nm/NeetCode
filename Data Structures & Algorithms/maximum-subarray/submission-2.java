/**
* we are given an array of integers nums
*
* find subarray with largest sum and return sum
*
* we can use Kadane's Algorithm to solve this question:
* 1. set current sum to 0 and max sum to 1st element in nums
*
* 2. traverse through nums:
*    -compute current sum as itself + current elem in nums
*    -update max sum as max of itself and current sum
*    -if current sum is negative -> set it to 0
*
* 3. return max sum seen so far
*/
class Solution {
    public int maxSubArray(int[] nums) {
        // track current sum
        int currentSum = 0;

        // set max sum to 1st elem in nums
        int maxSum = nums[0];

        // traverse through nums
        for(int num : nums) {
            // compute current sum
            currentSum += num;

            // update max sum seen so far
            maxSum = Math.max(maxSum, currentSum);

            // if sum negative -> set sum to 0
            if(currentSum < 0) currentSum = 0;
        }

        // return highest sum seen so far
        return maxSum;
    }
}
