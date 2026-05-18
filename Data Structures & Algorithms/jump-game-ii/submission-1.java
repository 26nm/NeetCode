class Solution {
    public int jump(int[] nums) {
        // track # of jumps needed, start at 0
        int jumps = 0;

        // set left & right bounds to 0
        int left = 0;
        int right = 0;

        // iterate while right bound has not reached end yet
        while(right < nums.length - 1) {
            // track farthest reachable index, start at 0
            int farthest = 0;

            // explore current jump range
            for(int i = left; i <= right; i++) {
                // update farthest to max of itself and index + value at index
                farthest = Math.max(farthest, i + nums[i]);
            }

            // move to next range
            left = right + 1;
            right = farthest;

            // increment jumps
            jumps++;
        }

        // return # of jumps needed
        return jumps;
    }
}
