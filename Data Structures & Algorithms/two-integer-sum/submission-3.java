class Solution {
    /**
    * perhaps the most famous DSA question
    *
    * we are given integer array and target value
    *
    * we return two indices such that their combined
    * values equal the target value
    *
    * we are always guaranteed a solution
    *
    * to solve this, we could:
    * 1. declare a new HashMap to track seen values
    *
    * 2. iterate through nums[]:
    *    -calculate the complement as comp = (target - nums[i]):
    *    -if map contains comp, return map.get(comp), i
    *    -otherwise, add {nums[i], i} to the map
    *
    * 3. return an empty array (value not found)
    */ 
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        // iterate through nums[]
        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if(seen.containsKey(comp)) {
                return new int[]{seen.get(comp), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
