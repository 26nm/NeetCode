class Solution {
    /**
    * we are given an integer array nums and integer k
    * -nums has a sliding window of size k that starts at
    *  array left edge, slides one position to right
    *  until it reaches right edge
    *
    * return list containing max element in window at each step
    *
    * to solve this, use monotonic decreasing deque and sliding window:
    * 1. iterate through nums:
    *    -clear indices
    *    -maintain decreasing order
    *    -add to result if window full
    *
    * 2. return this array
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init variables
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> steps = new ArrayDeque<>();
        int index = 0;

        // iterate to end of nums
        for(int i = 0; i < nums.length; i++) {
            // clear indices
            if(!steps.isEmpty() && steps.peekFirst() == i - k) {
                steps.pollFirst();
            }

            // maintain decreasing order
            while(!steps.isEmpty() && nums[steps.peekLast()] < nums[i]) {
                steps.pollLast();
            }

            steps.offerLast(i);

            // add to result if window full
            if(i >= k - 1) {
                result[index++] = nums[steps.peekFirst()];
            }
        }

        return result;
    }
}
