class Solution {
    /**
    * we are given an array of distinct integers nums, sorted in
    * ascending order, and integer target
    *
    * implement function to search for target within nums
    * -must run in O(Log N) time
    *
    * to solve this question, we can use the binary search algorithm:
    * 1. set low to 0, high to nums.length - 1
    *
    * 2. while low <= high:
    *    -calculate mid as low + (high - low) / 2
    *    -if mid == target -> return mid
    *    -else mid < target -> mid = high - 1;
    *    -else -> mid = low + 1;
    *
    * 3. return -1 if not found
    */
    public int search(int[] nums, int target) {
        // init variables
        int low = 0, high = nums.length - 1;

        // iterate until high and low intersect
        while(low <= high) {
            // calculate mid
            int mid = low + (high - low) / 2;

            // if mid is same as target, return
            if(nums[mid] == target) return mid;

            // mid too big
            else if(target < nums[mid]) {
                high = mid - 1;

            // mid too small
            } else {
                low = mid + 1;
            }
        }

        // element not found
        return -1;
    }
}
