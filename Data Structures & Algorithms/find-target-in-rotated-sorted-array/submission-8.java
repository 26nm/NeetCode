class Solution {
    /**
    * we are given an array of length n, originally sorted in ascending order
    * -it has now rotated between 1 and n times
    *
    * given this array and an integer target, return the index of target within nums,
    * or -1 if not found
    * -you may assume all elements in sorted rotated array are unique
    *
    * to solve this question, we can use binary search:
    * 1. calculate current mid
    *    -if nums[mid] matches target -> return true
    *    -else check if left half is sorted:
    *    -if nums[left] 
    */
    public int search(int[] nums, int target) {
        // init variables
        int left = 0, right = nums.length - 1;

        // iterate until left and right meet
        while(left <= right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // match found
            if(nums[mid] == target) return mid;

            // check if left-half is sorted
            if(nums[left] <= nums[mid]) {
                // check if target exists within this range
                if(nums[left] <= target && target < nums[mid]) {
                    // shrink from the right if so
                    right = mid - 1;

                // target not in this range, shrink from left    
                } else {
                    left = mid + 1;
                }

            // check if right-half is sorted   
            } else {
                // check if target exists within this range
                if(nums[right] >= target && target > nums[mid]) {
                    // if so, shrink from left
                    left = mid + 1;

                // target not within this range, shrink from right    
                } else {
                    right = mid - 1;
                }
            }
        }

        // target not found
        return -1;
    }
}
