/**
* implement the MedianFinder class:
*
* MedianFinder() is the constructor
*
* addNum(int num) adds integer num from data stream to data struct
*
* findMedian() returns median of all elements so far
*
* for MedianFinder():
* 1. create two heaps small and large
*    -small is a max heap (top values in decreasing order)
*    -large is min heap (top values in increasing order)
*
* for addNum(int):
* 1. add element to small heap
*
* 2. add biggest element to large heap
*    -if small becomes larger -> add element from small
*
* for findMedian():
* 1. if small and large heaps same size -> average both tops
*    -otherwise return top of small heap
*/
class MedianFinder {
    // define instance variables
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    // init variables
    public MedianFinder() {
        // max heap
        small = new PriorityQueue<>(Collections.reverseOrder());

        // min heap
        large = new PriorityQueue<>();
    }
    
    // add num to data struct
    public void addNum(int num) {
        // add element to small heap
        large.offer(num);

        // maintain ordering
        small.offer(large.poll());

        // if small heap becomes larger -> remove biggest element
        if(small.size() > large.size()) {
            large.offer(small.poll());
        }
    }
    
    // calc median
    public double findMedian() {
        // if even # of elements -> average top of both heaps
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }

        // otherwise return top of small heap
        return large.peek();
    }
}
