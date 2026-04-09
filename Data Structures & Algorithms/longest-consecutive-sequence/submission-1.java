class Solution {
    /**
    * we are given an int array
    *
    * we are asked to find longest consecutive sequence
    * -in a sequence, each element is exactly 1 bigger than previous
    * -elements in original array do not have to be consecutive
    *
    * to solve this, we could:
    * 1. transfer all numbers into a HashSet
    *
    * 2. loop through each number in HashSet:
    *    -declare variable to track longest, current length, current number (init to 1)
    *    -determine if it starts sequence (check if num - 1 is absent):
    *    -if it is a sequence starter, loop while it has a num + 1:
    *     -increment current and length
    *
    * 3. update longest to whatever is bigger between current length and known longest
    * 
    * 4. return this value
    */
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> seen = new HashSet<>();

       // transfer contents
       for(int n : nums) {
        seen.add(n);
       } 

       int longest = 0;

       // find sequence starters
       for(int num : seen) {
        if(!seen.contains(num - 1)) {
            int length = 1;
            int current = num;

            while(seen.contains(current + 1)) {
                length++;
                current++;
            }

            longest = Math.max(longest, length);
        }
       }

       return longest;

    }
}
