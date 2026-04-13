class Solution {
    /**
    * we are given a String
    *
    * we are asked to return length of longest substring without 
    * repeating characters
    *
    * this is a famous DSA question that introduces sliding window technique
    *
    * to solve this, we could:
    * 1. declare HashMap<Character, Integer> seen, maxLength to 0, start to 0
    *
    * 2. for 0 to end of string:
    *    -extract char at current index
    *    -check for dupes in the set:
    *     -if(seen.containsKey(ch) && seen.get(ch) >= start)
    *       start = seen.get(ch) + 1;
    *    -put char and current index into seen
    *    -update maxLength as Math.max(maxLength, i - start + 1)
    *
    * 3. return the maxLength
    */
    public int lengthOfLongestSubstring(String s) {
        // init character
        int maxLength = 0, start = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        // loop thru s
        for(int i = 0; i < s.length(); i++) {
            // extract current char
            char ch = s.charAt(i);

            // check for dupes within set
            if(seen.containsKey(ch) && seen.get(ch) >= start) {
                start = seen.get(ch) + 1;
            }

            seen.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
