class Solution {
    public int lengthOfLongestSubstring(String s) {
        // init variables
        int maxLength = 0, start = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        // loop 0 to end of s
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check if seen in map and advance start if necessary
            if(seen.containsKey(ch) && seen.get(ch) >= start) {
                start = seen.get(ch) + 1;
            }

            seen.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
