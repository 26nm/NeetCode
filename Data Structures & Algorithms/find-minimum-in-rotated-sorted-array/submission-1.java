class Solution {
    /**
    * we are given an array of length n, originally sorted in ascending order
    * -it has been rotated somewhere between 1 and n times
    *
    * assuming all elements in rotated sorted array are unique, return min element
    * of this array
    *
    * to solve this question, we can use binary search:
    * 1. calculate the mid:
    *    -if nums[mid] > nums[right] -> min must be to the right -> mid is left + 1
    *    -otherwise, mid must be to the left -> mid is right
    *
    * 2. return nums[left]
    */
    public int findMin(int[] nums) {
        // init variables
        int left = 0;
        int right = nums.length - 1;

        // iterate until left and right meet
        while(left < right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // if mid bigger than the right, min must be to the right
            if(nums[mid] > nums[right]) {
                left = mid + 1;

            // min must be to the left
            } else {
                right = mid;
            }
        }

        // return left bound
        return nums[left];
    }
}
