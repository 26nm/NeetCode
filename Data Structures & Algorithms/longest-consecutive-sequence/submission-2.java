class Solution {
    /**
    * we are given an int array
    *
    * we are asked to return an int representing longest
    * possible consecutive sequence 
    * -in each consecutive sequence, all nums are exactly 1
    *  bigger than their previous
    *  
    * we could use the sequence starter approa
    * 
    * to solve this, we could:
    *
    * 1. transfer all nums to HashSet
    *
    * 2. declare a variable longest to track known length
    *
    * 3. iterate through the HashMap:
    *    -if set DOES NOT contains (current - 1):
    *     -while (current + 1) exists:
    *     -increment the length
    *     -and pointer
    *     -update length to the max between current and longest
    * 
    * 4. return this value
    */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        // transfer all numbers
        for(int num : nums) {
            seen.add(num);
        }

        int longest = 0;

        // find sequence starters
        for(int n : seen) {
            if(!seen.contains(n - 1)) {
                int length = 1;
                int current = n;

                while (seen.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
