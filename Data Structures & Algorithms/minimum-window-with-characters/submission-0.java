class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] countT = new int[128];
        for(char c : t.toCharArray()) countT[c]++;

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;
        int need = t.length();

        while(right < s.length()) {
            char c = s.charAt(right);

            if(countT[c] > 0) need--;
            countT[c]--;
            right++;

            while(need == 0) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                countT[leftChar]++;
                if(countT[leftChar] > 0) need++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
