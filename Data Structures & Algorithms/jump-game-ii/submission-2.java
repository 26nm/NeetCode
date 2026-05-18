/**
* we are given array of integers nums, where nums[i] represents max length
* of jump towards the right from index i
* -if you are at nums[i], you can jump to any index i + j where
*  -j <= nums[i]
*  -i + j < nums.length
* -initially positioned at nums[0]
*
* return minimum # of jumps to reach last position in the array (nums.length - 1)
*
* to solve this, we can implement the following algorithm:
* 1. track # of jumps needed, start at 0
*
* 2. set left and right bounds to 0
*
* 3. iterate while right bound has not yet reached end:
*    -track farthest reachable index, start at 0
*    -explore current jump range:
*     -update farthest to max of itself and index + value at index
*    -adjust left and right bounds
*    -increment jumps
*
* 4. return # of jumps needed
*/
class Solution {
    public int jump(int[] nums) {
        // track # of jumps needed, start at 0
        int jumps = 0;

        // set left & right bounds to 0
        int left = 0;
        int right = 0;

        // iterate while right bound has not yet reached end:
        while(right < nums.length - 1) {
            // track farthest reachable index, start at 0
            int farthest = 0;

            // explore current jump range
            for(int i = left; i <= right; i++) {
                // update farthest to max of itself plus index and its value in nums
                farthest = Math.max(farthest, i + nums[i]);
            }

            // adjust left & right
            left = right + 1;
            right = farthest;

            // increment jumps
            jumps++;
        }

        // return # of jumps needed
        return jumps;
    }
}
