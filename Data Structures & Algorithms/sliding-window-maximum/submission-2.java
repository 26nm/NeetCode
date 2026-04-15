class Solution {
    /**
    * we are given integer array nums and integer k
    * a sliding window of size k starts at left edge of array
    * window slides one position to right til it reaches end
    *
    * return list containing maximum element in window at each step
    *
    * this problem introduces new data structure (double-ended queue)
    *
    * we use monotonic decreasing deque and sliding window to solve this
    *
    * we could:
    * 1. init:
    *    -Deque<Integer> steps = new ArrayDeque<>();
    *    -index = 0;
    *    -int[] result = new int[nums.length - k + 1];
    *
    * 2. iterate 0 to end of nums:
    *    -remove indices from window
    *    -maintain decreasing order
    *    -add to result
    *
    * 3. return result;
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> steps = new ArrayDeque<>();
        int index = 0;
        int[] result = new int[nums.length - k + 1];

        // iterate to end of nums
        for(int i = 0; i < nums.length; i++) {
            // remove indices from window
            if(!steps.isEmpty() && steps.peekFirst() == i - k) {
                steps.pollFirst();
            }

            // maintain decreasing order
            while(!steps.isEmpty() && nums[steps.peekLast()] < nums[i]) {
                steps.pollLast();
            }

            steps.offerLast(i);

            // add result when window full
            if(i >= k - 1) {
                result[index++] = nums[steps.peekFirst()];
            }
        }

        return result;
    }
}
