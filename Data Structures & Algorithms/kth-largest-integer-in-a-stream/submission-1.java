/**
* design a class to find kth largest integer in a stream of values, including
* duplicates
*
* to solve this question, we can use a min heap, since it'll always
* return the kth smallest among maximum elements:
* 1. add value to heap
*    -if heap size exceeds k, remove smallest
*
* 2. return top of the heap
*/
class KthLargest {
    // define instance variables
    private int k;
    private PriorityQueue<Integer> minHeap;

    // init instance variables
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // transfer elements from nums to min heap
        for(int num : nums) {
            add(num);
        }
    }
    
    // add elements to heap
    public int add(int val) {
        // add element to heap
        minHeap.offer(val);

        // if heap size exceeds k -> remove minimum value
        if(minHeap.size() > k) {
            minHeap.poll();
        }

        // return top of heap
        return minHeap.peek();
    }
}
