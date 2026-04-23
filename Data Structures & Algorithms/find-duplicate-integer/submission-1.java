class Solution {
    /**
    * we are given an array of integers nums containing n+1 integers
    * -each integer in nums is in the range [1, n] inclusive
    *
    * find integer appearing more than once
    *
    * to solve this, we could:
    * 1. find cycle entry point
    *
    * 2. iterate through cycle 
    *
    * 3. return the result
    */
    public int findDuplicate(int[] nums) {
        // init variables
        int fast = nums[0];
        int slow = nums[0];

        // find entry point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while(slow != fast);

        // iterate through cycle
        slow = nums[0];

        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
