class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }

            map.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
