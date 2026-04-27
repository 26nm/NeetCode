class Solution {
    /**
    * we are given array of length n which was originally sorted in
    * ascending order
    * -it has now been rotated somewhere between 1 and n times
    *
    * given the rotated sorted array nums and an integer target, return index
    * of target within nums, or -1 if absent
    *
    * to solve this, we can apply a strategy similar to the previous problem:
    * 1. set left -> 0, right -> nums.length - 1
    *
    * 2. while(left < right):
    *    -calc mid
    *    -if nums[mid] == target -> return mid
    *    -else if nums[mid] > right -> left -> mid + 1
    *    -else -> mid -> right
    *
    * 3. return -1
    */
    public int search(int[] nums, int target) {
        // init variables
        int left = 0, right = nums.length - 1;

        // iterate while left < right
        while(left <= right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // match found
            if(nums[mid] == target) return mid;

            // check if left-half is sorted
            if(nums[left] <= nums[mid]) {
                // check if target exists within this half
                if(nums[left] <= target && target < nums[mid]) {
                    // shrink from right
                    right = mid - 1;

                // shrink from left    
                } else {
                    left = mid + 1;
                }

            // check if right-half is sorted
            } else {
                // check if target exists within this half
                if(nums[mid] < target && target <= nums[right]) {
                    // shrink from left
                    left = mid + 1;

                // shrink from right    
                } else {
                    right = mid - 1;
                }
            }
        }

        // target not found
        return -1;
    }
}
