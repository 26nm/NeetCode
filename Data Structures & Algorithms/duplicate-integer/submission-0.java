class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for(int val : nums) {
            if(seen.contains(val)) return true;
            seen.add(val);
        }

        return false;
    }
}

// COMMENTS
// STRUCTURE
// IMPLEMENTATION

// COMMENTS
// we're given an array of integers
// we're asked to return true if any value appears more than once
// otherwise return false

// STRUCTURE
// initialize an empty set of integers
    // key: the number itself
    // value: its frequency

// iterate through nums:
    // if current value has count > 0
        // exit early and return true

    // add value to the set, increment frequency by 1
// return false

// IMPLEMENTATION
