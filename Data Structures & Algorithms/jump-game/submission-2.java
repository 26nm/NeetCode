/**
* we are given an integer array nums where each element nums[i] indicates
* maximum jump length at that position
*
* return true if you can reach last index starting from index 0
* -return false otherwise
*
* we can solve this question but implementing the following algorithm:
* 1. track how far you can go -> start at 0
*
* 2. traverse through nums:
*    -if current index bigger than farthest -> unreachable, return false
*    -update farthest to max of itself and index plus nums at index
*
* 3. return true 
*/
class Solution {
    public boolean canJump(int[] nums) {
        // track how far you can go, start at 0
        int farthest = 0;

        // traverse through nums
        for(int i = 0; i < nums.length; i++) {
            // if index bigger than farthest -> unreachable
            if(i > farthest) return false;

            // update farthest to max of itself and current index + value at index
            farthest = Math.max(farthest, i + nums[i]);
        }

        // end successfully reached
        return true;
    }
}
