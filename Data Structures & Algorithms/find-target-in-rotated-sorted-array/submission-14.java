class Solution {
    /**
    * we are given an array nums of length n, which was originally sorted in
    * ascending order
    * -it has now been rotated between 1 and n times
    *
    * given this rotated array and an integer target return the index of target
    * within nums, or -1 if not present
    *
    * to solve this, we can perform binary search on both sorted halves:
    * 1. calculate the current mid:
    *    -if nums[mid] == target -> return mid
    *    -if nums[left] <= nums[mid] -> check if target exists within left-half:
    *     -if nums[left] <= nums[mid] AND mid less than target -> shrink left
    *     -otherwise target not within this range -> shrink right
    *    -target must be in sorted right-half:
    *     -if nums[right] >= nums[mid] AND mid bigger than target -> shrink right
    *     -otherwise target not within this range -> shrink left
    *
    * 2. return -1
    */
    public int search(int[] nums, int target) {
        // init variables
        int left = 0, right = nums.length - 1;

        // iterate until left and right intersect
        while(left <= right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // match found, return mid
            if(nums[mid] == target) return mid;

            // check if target is in sorted left-half
            if(nums[left] <= nums[mid]) {
                // check if target is within this range
                if(nums[left] <= target && nums[mid] > target) {
                    // shrink from left
                    right = mid - 1;

                // target not within this range, shrink right    
                } else {
                    left = mid + 1;
                }
            
            // check if target is in sorted right-half
            } else {
                // check if target is within this range
                if(nums[right] >= target && nums[mid] < target) {
                    // shrink right
                    left = mid + 1;

                // target not within this range, shrink left
                } else {
                    right = mid - 1;
                }
            }
        }

        // target not found
        return -1;
    }
}
