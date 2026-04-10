class Solution {
    /**
    * we are given an integer array and integer k
    *
    * return an int array containing k most frequent elements
    *
    * best approach for this problem is bucket sort
    *
    * we could:
    * 1. declare new HashMap<Integer, Integer> result
    *
    * 2. iterate through nums[]:
    *    -determine frequency of each number (always init each to 1)
    *    -declare new List<>[] buckets[nums.length + 1] to sort frequency values
    *    -if buckets[i] is null
    *     -give it a new ArrayList
    *     -add this value to the bucket
    *
    * 3.  declare int index to 0 (track position) and int[] result[length k]
    *     iterate through the bucket, starting from highest frequency
    *     -iterate ONLY WHILE i >= 0 and index < k
    *     -if buckets[i] is NOT NULL:
    *      -iterate through buckets[i]
    *      -result[index] = num
    *      -if (index == k) break
    *
    * 4.  return result array
    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        // calculate freq for each number
        for(int num : nums) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        // create buckets to sort freqs
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int num : seen.keySet()) {
            int freq = seen.get(num);

            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // collect top k most frequent elements
        int[] result = new int[k];
        int index = 0;

        for(int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    result[index++] = num;
                    if(index == k) break;
                }
            }
        }

        return result;
    }
}
