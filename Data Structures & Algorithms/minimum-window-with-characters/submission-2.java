class Solution {
    /**
    * we are given two strings s and t
    *
    * return shortest substring of s
    * such that every character t is in it
    *
    * to solve this, we can use sliding window 
    * and two pointers
    *
    * we could:
    * 1. return "" if t is longer than s
    *
    * 2. build freq arrat for t, 128 ints long
    *
    * 3. init bookkeeping variables:
    *    -int left = 0
    *    -int right = 0
    *    -int minLen = Integer.MAX_VALUE
    *    -int start = 0
    *    -int need = 0
    *
    * 4. loop while right < s.length():
    *    -char rightChar = s.charAt(rightChar)
    *    -if(freqT[rightChar] > 0) need--;
    *    -freqT[rightChar]--;
    *    -right++;
    *
    *    while(need == 0):
    *    -if(right - left < minLen):
    *    -minLen = right - left;
    *    -start = left
    *
    *    char leftChar = s.charAt(leftChar)
    *    -if(freqT[leftChar] > 0) need++
    *    -freqT[leftChar]++;
    *    -left++;
    *
    * 5. return minLen == MAX.LENGTH ? "" : s.substring(start, start + minLen)
    */
    public String minWindow(String s, String t) {
        // return "" if t is longer
        if(s.length() < t.length()) return "";

        // build freq array for T
        int[] freqT = new int[128];
        for(char c : t.toCharArray()) freqT[c]++;

        // init bookkeeping
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0, need = t.length();

        // iterate thru end of string
        while(right < s.length()) {
            // process from right and determine need
            char rightChar = s.charAt(right);
            if(freqT[rightChar] > 0) need--;
            freqT[rightChar]--;
            right++;

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
