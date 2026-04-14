class Solution {
    /**
    * we are given two strings s and t
    *
    * return the shortest substring of s
    * such that it contains t
    *
    * to solve this, we can use the sliding window
    * and two pointers
    *
    * we could:
    * 1. return "" if t is longer than s
    *
    * 2. create freq array for T
    *
    * 3. init bookkeeper variables:
    *    -left to 0
    *    -right to 0
    *    -minLen to Integer.MAX_VALUE
    *    -start to 0
    *    -need to t's length
    *
    * 4. while(right < s.length()):
    *    -char rightChar = s.charAt(right)
    *     -if(freqT[rightChar] > 0) need--;
    *      freqT[rightChar]--;
    *      right++;
    *      -while(need == 0)
    *       if(right - left < minLen):
    *       -minLen = right - left
    *       -start = left
    *       char leftChar = s.charAt(left)
    *       freqT[leftChar]++
    *       if(freqT[leftChar] > 0) need++
    *       left++
    *
    * 5. return minLen == Integer.MAX_LENGTH ? "" : s.substring(start, start + minLen) 
    */
    public String minWindow(String s, String t) {
        // return "" if t longer than s
        if(s.length() < t.length()) return "";

        // create freq array for t
        int[] freqT = new int[128];
        for(char ch : t.toCharArray()) freqT[ch]++;

        // init bookkeeping
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        int start = 0, need = t.length();

        // iterate through end of s starting with right
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if(freqT[rightChar] > 0) need--;
            freqT[rightChar]--;
            right++;

            while(need == 0) {
                if(right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freqT[leftChar]++;
                if(freqT[leftChar] > 0) need++;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
