class Solution {
    /**
    * we are given integer array 
    *
    * we are asked to determine if it has value
    * occurring more than once
    *
    * if so, return true. otherwise false.
    *
    * we could:
    * 1. declare new HashSet
    *
    * 2. for each number in nums:
    *    -if number already exists, return true
    *    -otherwise, add to the map
    *
    * 3. return false
    */
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        // iterate array
        for(int num : nums) {
            if(seen.contains(num)) { return true; }

            seen.add(num);
        }

        return false;
    }
}