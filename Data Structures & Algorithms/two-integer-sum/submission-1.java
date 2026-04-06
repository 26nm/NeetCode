class Solution {
    /**
    * this is a very classic DSA problem
    *
    * we are given an array of integers and a target value
    *
    * we are asked to return two indices such that their values
    * total to the target value
    *
    * the naive approach is to use a nested for-loop to sum every index
    * until its sum matches the index
    *
    * but a more efficient and optimal approach is to use a HashMap to track
    * the complement and previously seen values
    *
    * we calculate this value as:
    * diff = target - current elem
    *
    * if the complement exists, return index of:
    * -current element (i)
    * -complement (diff)
    *
    * else:
    * -store current element in HashMap with its index and continue
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        // iterate thru nums
        for(int i = 0; i < nums.length; i++) {
            // calculate complement
            int comp = target - nums[i];

            // check if complement exists within map
            if(seen.containsKey(comp)) {
                return new int[]{seen.get(comp), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
