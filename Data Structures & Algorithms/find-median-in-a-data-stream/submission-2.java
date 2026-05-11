/**
* implement the MedianFinder class with following attributes:
*
* MedianFinder(): initializes data struct
*
* void addNum(int num): adds integer num from data stream to data struct
*
* double findMedian(): returns median of all elements so far
*
* for MedianFinder():
* 1. create a max heap to store smaller half and min heap to store larger half
*
* for addNum(int num):
* 1. add num to max heap
*
* 2. add biggest element to min heap to maintain ordering
*
* 3. if max heap becomes smaller than min heap -> add smallest to max heap
*
* for findMedian():
* 1. if min and max heaps same size -> average their tops
*    -otherwise return top of max heap
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
        // add element to smaller half
        small.offer(num);

        // add biggest element from small to large
        large.offer(small.poll());

        // if min heap becomes longer than max -> move smallest to max heap
        if(small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    // calc median
    public double findMedian() {
        // if heap sizes same (even # of nums) -> average tops
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }

        // median is top of smaller half
        return small.peek();
    }
}
