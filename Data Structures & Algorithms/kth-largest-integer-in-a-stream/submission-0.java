/**
* design class to find the kth largest integer in a stream of values
* including duplicates
*/
class KthLargest {
    // define instance variables
    private PriorityQueue<Integer> minHeap;
    private int k;

    // init instance variables
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // transfer elements from nums to heap
        for(int num : nums) {
            add(num);
        }
    }
    
    // add elements to heap
    public int add(int val) {
        // offer value
        minHeap.offer(val);

        // if heap size exceeds k, remove smallest
        if(minHeap.size() > k) {
            minHeap.poll();
        }

        // return top of heap
        return minHeap.peek();
    }
}
