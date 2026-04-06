class Solution {
    /**
    * we're asked to find k most frequent elements within an array
    *
    * example:
    *
    * [1,2,2,3,3,3], k = 2 --> [2,3]
    *
    * this means that '2' and '3' are the two most frequent elements
    *
    * i remember the optimal approach to solving this question involving
    * use of priority queues (heaps), but i have shaky fundamentals with this
    * data structure
    *
    * if the naive approach to this problem is counting number frequencies, how
    * exactly can we do this?
    * -it's almost like each number needs an associated value
    * -don't HashMaps do this well? a key and associated value?
    * -maybe something like <Integer, Integer> map or something?
    *
    * what if we looped through nums to count frequencies first?
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count number frequencies (initialize to 1)
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // initialize a priority queue of map entries, ascending order
        PriorityQueue<Map.Entry<Integer, Integer>> heap 
            = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());


        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);

            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;

        while(!heap.isEmpty()) {
            result[i++] = heap.poll().getKey();
        }

        return result;
    }
}
