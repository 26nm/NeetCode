/**
* we are given an array of integers stones where stones[i] represents
* weight of ith stone
*
* run simulation on stones as follows:
* -each step, choose two heaviest stones, with weight x and y, smash together
* -if x same as y -> both destroyed
* -if x < y -> weight x destroyed, y has new weight y - x
*
* continue simulation until no stones remain
*
* return weight of last remaining stone or return 0 if none remain
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        // create max heap to process stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // process each stone weight
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        // while heap contains at least 2 stones
        while(maxHeap.size() > 1) {
            // extract two heaviest stones
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            // if weights differ -> subtract their weights, adjust heavier to diff between them
            if(y != x) maxHeap.offer(y - x);
        }

        // return 0 if empty heap, or remaining stone in heap
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
