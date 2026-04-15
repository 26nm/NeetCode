class Solution {
    /**
    * we are given integer array and integer k
    * -it has sliding window of size k that starts at left edge
    * -it slides right until it reaches right edge of array
    *
    * return array containing max element in window at each step
    *
    * to solve this, we could use monotonic decreasing deque and
    * sliding window
    *
    * we could:
    * 1. init: 
    *    -int index = 0
    *    -int result = new int[nums.length - k + 1]
    *    -Deque<Integer> steps = new ArrayDeque<>()
    *
    * 2. loop from 0 to end of nums:
    *    -remove indices from window
    *    -maintain decreasing order
    *    -add to result when window full
    *
    * 3. return result
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init variables
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> steps = new ArrayDeque<>();

        // loop from 0 to end of nums
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

            // add to result if window full
            if(i >= k - 1) {
                result[index++] = nums[steps.peekFirst()];
            }
        }

        return result;
    }
}
