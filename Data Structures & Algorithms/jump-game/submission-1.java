class Solution {
    public boolean canJump(int[] nums) {
        // track farthest jump possible, start at 0
        int farthest = 0;

        // traverse through nums
        for(int i = 0; i < nums.length; i++) {
            // check if current index unreachable
            if(i > farthest) return false;

            // update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
        }

        // end successfully reached
        return true;
    }
}
