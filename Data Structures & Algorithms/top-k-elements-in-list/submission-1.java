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
        Map<Integer, Integer> freqMap = new HashMap<>();

        // count frequencies
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // buckets by frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int num : freqMap.keySet()) {
            int freq = freqMap.get(num);

            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // collect top k frequent
        int[] result = new int[k];
        int index = 0; 

        for(int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if(buckets[i] != null) {
                for(int num: buckets[i]) {
                    result[index++] = num;
                    if(index == k) break;
                }
            }
        }

        return result;
    }
}
