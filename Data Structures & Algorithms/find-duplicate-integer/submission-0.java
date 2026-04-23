class Solution {
    /**
    * we are given array of integers nums containing n+1 integers
    * -each integer in nums is in the range [1, n] inclusive
    *
    * every integer appears exactly once, except for one integer which
    * appears two or more times
    *
    * return integer appearing more than once
    *
    * like linked lists, what if we used fast and slow pointers to find
    * duplicate?
    *
    * a basic idea:
    * 1. set slow to beginning of array, fast to slow's index + 1
    *
    * 2. if nums[fast] matches num[slow], return i
    */
    public int findDuplicate(int[] nums) {
        // init variables
        int slow = nums[0];
        int fast = nums[0];

        // find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        // find entry point
        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
