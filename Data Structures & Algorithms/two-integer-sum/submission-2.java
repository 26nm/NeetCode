class Solution {
    /**
    * the most famous DSA problem
    *
    * we are given an integer array and target value
    *
    * return the two indices whose values summed together
    * equal the target value
    *
    * the most optimal approach is to use a HashMap:
    * -calculate complement (target - nums[current_element])
    * -check if complement is in the map:
    *  1. if so, return index of this complement and current index
    *  2. otherwise add current array value and index to map
    *
    * otherwise, return an empty array since we're always guaranteed a solution
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        // scan for complements
        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if(seen.containsKey(comp)) {
                // return index of complement and current index
                return new int[]{seen.get(comp), i};
            }

            // add current elem and its index to map
            seen.put(nums[i], i);
        }

        return new int[]{}; // solution always guaranteed;
    }
}
