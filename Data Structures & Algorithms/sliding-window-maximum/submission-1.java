class Solution {
    /**
    * we are given an array of integers nums and int k
    * -there is sliding window of size k that starts at
    *  left edge of array
    *
    * return list that contains max element in window at each step
    *
    * to solve this, we could use a monotonic deque + sliding window
    *
    * we could:
    * 1. declare:
    *    -int[] result = new int[nums.length - k + 1]
    *    -Deque<Integer> dq = new Deque<>();
    *
    * 2. loop 0 through end of nums:
    *    -remove indices from window
    *    -maintain descending order
    *    -add result to window
    *
    * 3. return result
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init variables
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;

        // loop 0 through end of nums
        for(int i = 0; i < nums.length; i++) {
            // remove indices from window
            if(!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // maintain decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // add result when window is full
            if(i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
