class Solution {
	/**
	* this is another common DSA question
	*
	* we are given an integer array and a target value k
	*
	* return top k most frequent elements
	*
	* we could use Bucket Sort to solve this question
	*
	* we might:
	* 1. create a HashMap of integers to store numbers and freqs
	* 2. count each frequency
	* 3. create buckets based on frequencies 
	* 4. collect frequencies, starting with the highest
	*/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<>();

		// count frequencies
		for(int n : nums) {
			freqs.put(n, freqs.getOrDefault(n, 0) + 1);
		}

		// create frequency buckets
		List<Integer>[] buckets = new ArrayList[nums.length + 1];

		for(int n : freqs.keySet()) {
			int freq = freqs.get(n);

			if(buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}

			buckets[freq].add(n);
		}

		// collect top k most frequent elements
		int index = 0;
		int[] result = new int[k];

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
