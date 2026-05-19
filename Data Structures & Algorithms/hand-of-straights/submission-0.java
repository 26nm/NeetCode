class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // return false if cards do not evenly divide
        if(hand.length % groupSize != 0) return false;

        // create a map to count card frequencies
        Map<Integer, Integer> countMap = new HashMap<>();

        // calc card freqs
        for(int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // create min heap to process smallest remaining cards
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(countMap.keySet());

        // while heap not empty, get smallest card and build sequence
        while(!minHeap.isEmpty()) {
            // get smallest card
            int start = minHeap.peek();

            // build consecutive group
            for(int i = start; i < start + groupSize; i++) {
                // if required card missing -> return false
                if(!countMap.containsKey(i)) return false;

                // update card freq in map
                countMap.put(i, countMap.get(i) - 1);

                // remove exhausted card
                if(countMap.get(i) == 0) {
                    // first check if ordering invalid
                    if(i != minHeap.peek()) return false;

                    // remove card from both heap and map
                    minHeap.poll();
                    countMap.remove(i);
                }
            }
        }

        // all cards successfully rearranged
        return true;
    }
}
