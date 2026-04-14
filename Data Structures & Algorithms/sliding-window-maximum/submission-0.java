class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init variables
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        // iterate 0 through end of nums
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
