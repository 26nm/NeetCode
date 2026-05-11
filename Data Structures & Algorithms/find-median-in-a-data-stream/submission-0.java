class MedianFinder {
    // define instance variables
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    // init instance variables
    public MedianFinder() {
        // max heap
        small = new PriorityQueue<>(Collections.reverseOrder());

        // min heap
        large = new PriorityQueue<>();
    }
    
    // add number to data struct
    public void addNum(int num) {
        // add to smaller half
        small.offer(num);

        // maintain ordering
        large.offer(small.poll());

        // maintain size balance
        if(large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    
    // calculate median
    public double findMedian() {
        // if # of elements even -> average top of both heaps
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }

        // otherwise median is top of small heap
        return small.peek();
    }
}
