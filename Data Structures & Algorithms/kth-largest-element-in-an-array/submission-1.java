/**
* we are given unsorted array of integers nums and an integer k
*
* return kth largest element in the array
* -by kth largest element, we mean kth largest in sorted order, not kth distinct
*
* to solve this, we can maintain a min heap:
* 1. create priority queue as min heap
*
* 2. transfer element from array to heap:
*    -add to heap
*    -if heap full -> remove smallest
*
* 3. return topmost element -> this is kth largest
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // create priority queue as min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // transfer numbers from array to heap
        for(int num : nums) {
            minHeap.offer(num);

            // if heap full -> remove smallest
            if(minHeap.size() > k) minHeap.poll();
        }

        // return topmost element
        return minHeap.poll();
    }
}
