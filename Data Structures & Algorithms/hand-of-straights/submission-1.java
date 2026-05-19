/**
* we are given integer array hand where hand[i] is value written on
* ith card and an int groupSize
* -rearrange cards into groups such that each group is groupSize in size
*  and card values consecutively increase by 1
*
* return true if it's possible to rearrange cards in this way, false otherwise
*
* to solve this question, we can implement following algorithm:
* 1. if # of hands does not evenly divide into groupSize -> return false
*
* 2. create a map to store card freqs and populate with values
*
* 3. create min heap to process remaining cards
*
* 4. while heap is not empty:
*    -get smallest card
*    -try to build consecutive group with card
*     -if missing required card -> return false
*     -decrease freq
*     -if freq is 0 -> discard card entirely
*
* 5. return true
*/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // check if cards evenly divide first
        if(hand.length % groupSize != 0) return false;

        // create map to store card freqs
        Map<Integer, Integer> cardFreqs = new HashMap<>();

        // populate map with values
        for(int card : hand) {
            cardFreqs.put(card, cardFreqs.getOrDefault(card, 0) + 1);
        }

        // create min heap to process smallest remaining cards
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cardFreqs.keySet());

        // while heap not empty, try to build sequence for each card
        while(!minHeap.isEmpty()) {
            // get smallest card
            int start = minHeap.peek();

            // try to build group with smallest
            for(int i = start; i < start + groupSize; i++) {
                // check if we have the card
                if(!cardFreqs.containsKey(i)) return false;

                // update card freq
                cardFreqs.put(i, cardFreqs.get(i) - 1);

                // remove exhausted card
                if(cardFreqs.get(i) == 0) {
                    // also check if sequence invalid
                    if(i != minHeap.peek()) return false;

                    // remove card entirely
                    minHeap.poll();
                    cardFreqs.remove(i);
                }
            }
        }

        // all cards successfully rearranged
        return true;
    }
}
