class Solution {
    // helper function to rob houses 
    private int robRange(int[] nums, int left, int right) {
        // track money robbed from both houses, start at 0
        int rob1 = 0;
        int rob2 = 0;

        // iterate until left & right intersect
        for(int i = left; i <= right; i++) {
            // calc current robbery amount
            int current = Math.max(rob1 + nums[i], rob2);

            // shift window
            rob1 = rob2;
            rob2 = current;
        }

        // return money robbed from 2nd house
        return rob2;
    }

    // helper function
    public int rob(int[] nums) {
        // if input contains only 1 house -> return it
        if(nums.length == 1) return nums[0];

        // return max of robbing from both ranges
        return Math.max(
            robRange(nums, 0, nums.length - 2),
            robRange(nums, 1, nums.length - 1)
        );
    }
}
