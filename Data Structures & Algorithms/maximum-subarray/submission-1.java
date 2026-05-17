class Solution {
    public int maxSubArray(int[] nums) {
        // track current sum
        int currentSum = 0;

        // set max sum to 1st element in nums
        int maxSum = nums[0];

        // traverse through nums
        for(int num : nums) {
            // calc current sum as itself plus current num
            currentSum += num;

            // update max sum seen so far
            maxSum = Math.max(maxSum, currentSum);

            // if current sum is negative -> discard and start from 0
            if(currentSum < 0) currentSum = 0;
        }

        // return max sum computed
        return maxSum;
    }
}
