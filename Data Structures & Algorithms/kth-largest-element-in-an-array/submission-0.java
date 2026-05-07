class Solution {
    public int findKthLargest(int[] nums, int k) {
        // create priority queue to process elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // process each number in array
        for(int num : nums) {
            // add num to heap
            minHeap.offer(num);

            // if heap full -> remove smallest
            if(minHeap.size() > k) minHeap.poll();
        }

        // return topmost element
        return minHeap.peek();
    }
}
