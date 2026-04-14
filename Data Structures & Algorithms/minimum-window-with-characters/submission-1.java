class Solution {
    public String minWindow(String s, String t) {
        // if t is longer, return empty immediately
        if(s.length() < t.length()) return "";

        // create freq array for String t
        int[] freqT = new int[128];
        for(char c : t.toCharArray()) freqT[c]++;

        // init variables for bookkeeping
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0, need = t.length();

        // iterate while the right is less than s.length()
        while(right < s.length()) {
            char c = s.charAt(right);

            // borrow current characters from t and decrease need
            if(freqT[c] > 0) need--;
            freqT[c]--;
            right++;

            // while you don't need anything, adjust minLen and start
            while(need == 0) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // process from left and determine if you need more
                char leftChar = s.charAt(left);
                freqT[leftChar]++;
                if(freqT[leftChar] > 0) need++;
                left++;
            }
        }

        // return empty string if min not updated or what you currently have
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}
