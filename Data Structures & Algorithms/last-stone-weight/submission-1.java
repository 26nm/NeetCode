/**
* we are given array of integers stones where stones[i] represents weight of
* ith stone
*
* run simulation as follows:
* -choose two heaviest stones
* -if same weight -> smash both together
* -if x < y -> lighter weight destroyed, heavier one -> (heavy - light)
* -continue until 1 or none remain
*
* return weight of last remaining stone or return 0 if none remain
*
* to solve this, we can use a max heap:
* 1. create max heap
*    -transfer stone weights from stones to heap
*
* 2. extract 2 biggest values
*    -if y > x -> put (y - x) back in heap
*
* 3. return 0 if heap empty, top element in heap if 1 stone remains
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        // create max heap to store stone weights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // transfer stone weights to heap
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        // while heap contains at least 2 stones, process weights
        while(maxHeap.size() > 1) {
            // extract 2 heaviest stones
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            // if weights differ -> add difference of heavier and lighter back to heap
            if(y != x) maxHeap.offer(y - x);
        }

        // return 0 if empty, remaining stone otherwise
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
