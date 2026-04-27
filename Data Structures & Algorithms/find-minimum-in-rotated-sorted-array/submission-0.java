class Solution {
    /**
    * we are given an array of length n which was originally sorted in
    * ascending order
    * -it has been rotated between 1 and n times
    *
    * assuming all elements in rotated sorted array are unique, return
    * minimum element of this array
    *
    * for binary search to work, array must strictly be sorted in 
    * non-descending order
    *
    * so if nums is unsorted, how exactly can we perform binary search?
    * -sorting it again would worsen runtime to O(N Log N) at best
    */
    public int findMin(int[] nums) {
        // init variables
        int left = 0;
        int right = nums.length - 1;

        // iterate until left and right meet
        while(left < right) {
            // calc current mid
            int mid = left + (right - left) / 2;

            // minimum must be right of mid
            if(nums[mid] > nums[right]) {
                left = mid + 1;

            // minimum must be to the left of mid
            } else {
                right = mid;
            }
        }

        // return lower bound
        return nums[left];
    }
}
