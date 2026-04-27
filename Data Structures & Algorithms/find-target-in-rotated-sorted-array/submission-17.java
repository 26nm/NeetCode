class Solution {
    /**
    * we are given an array nums of length n, originally sorted in ascending order
    * -it has been rotated somewhere between 1 and n times
    *
    * given this rotated array and an integer target, return the index of target
    * within nums, or -1 if not present
    *
    * to solve this, we can perform binary search on both sorted halves:
    * 1. calculate current mid
    *    -if nums[mid] matches target -> return mid
    *    -else, if nums[left] <= nums[mid]:
    *     -if nums[left] <= target AND nums[mid] > target -> shrink right
    *     -otherwise shrink left
    *    -else
    *     -if nums[right] >= target AND nums[mid] < target -> shrink left
    *     -otherwise shrink right
    *
    * 2. return -1 (not found)
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

            // check if left-half sorted
            if(nums[left] <= nums[mid]) {
                // check if target exists within this range
                if(nums[left] <= target && nums[mid] > target) {
                    // target might exist here, shrink right
                    right = mid - 1;

                // target doesn't exist here, shrink left
                } else {
                    left = mid + 1;
                }

            // check if right-half sorted
            } else {
                // check if target exists within this range
                if(nums[right] >= target && nums[mid] < target) {
                    // target might exist here, shrink left
                    left = mid + 1;

                // target doesn't exist here, shrink right
                } else {
                    right = mid - 1;
                }
            }
        }

        // target not found
        return -1;
    }
}
