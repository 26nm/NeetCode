class Solution {
    public int[] twoSum(int[] nums, int target) {
        // IMPLEMENTATION
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if(seen.containsKey(comp)) {
                return new int[] {seen.get(comp), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
        
    }
}

// COMMENT
// STRUCTURE
// IMPLEMENTATION

// COMMENT
    // to solve this question, we return a pair of two numbers
    // representing indices whose values sum to the target
    // a famous approach to this problem is using complements
    // complements allow quick lookups instead of brute force
    // computations which add up over time 
    // we can use a HashMap and check if (target - k) exists

// STRUCTURE
    // for each number in nums:
        // int comp = target - nums
            // if comp is in nums:
                // return {map.get(number), complement}
            // else, add number and complement to map

    // else return empty array
