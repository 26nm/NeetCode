class Solution {
    /**
    * we are given two strings s and t
    *
    * return shortest substring of s such that it contains
    * t
    *
    * to solve this, we use a sliding window
    *
    * we could:
    * 1. create freq array of 128 (store all ASCII values)
    * 2. while right < s.length():
    *    -calculate need from right
    *    -calculate need from left
    *    -update minLen as needed
    *
    * 3. return result;
    */
    public String minWindow(String s, String t) {
        // return empty string if t longer than s
        if(s.length() < t.length()) return "";

        // init bookkeeping variables
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0, need = t.length();

        // create freq array
        int[] freqT = new int[128];
        for(char ch : t.toCharArray()) freqT[ch]++;

        // iterate s, starting with right
        while(right < s.length()) {
            // process each char, starting with the right
            char rightChar = s.charAt(right);
            if(freqT[rightChar] > 0) need--;
            freqT[rightChar]--;
            right++;

            // process from left while you do not need anything
            while(need == 0) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freqT[leftChar]++;
                if(freqT[leftChar] > 0) need++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
