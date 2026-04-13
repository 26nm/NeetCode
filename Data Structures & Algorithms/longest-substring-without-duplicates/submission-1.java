class Solution {
    public int lengthOfLongestSubstring(String s) {
        // init variables
        HashMap<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        // iterate through string
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check for duplicates and move window
            if(seen.containsKey(ch) && seen.get(ch) >= start) {
                start = seen.get(ch) + 1;
            }

            // track character index and update max length
            seen.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
