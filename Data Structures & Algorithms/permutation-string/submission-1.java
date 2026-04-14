class Solution {
    /**
    * we are given two strings
    *
    * return true if s2 contains a permutation of s1
    * as a substring
    *
    * otherwise return false
    * 
    * to solve this, we can compare frequency arrays within
    * a window
    *
    * to solve this, we could:
    * 1. return false if s1 longer than s2
    *
    * 2. create freq arrays of size 26 for s1 and s2
    *    -create them looping through s1
    *    -if they're identical, return true
    * 
    * 3. iterate s1.length() to end of s2:
    *    -count2[s2.charAt(right) -'a']++;
    *    -count2[s2.charAt(left) - 'a']++;
    *    -left++
    *    -if arrays match, return true
    *
    * 4. return false
    */
    public boolean checkInclusion(String s1, String s2) {
        // return false if s1 longer than s2
        if(s1.length() > s2.length()) return false;

        // create freq arrays for both strings
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // calc freq arrays
        for(int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // check if identical
        if(Arrays.equals(freq1, freq2)) return true;

        // find matches within window
        int left = 0;

        for(int right = s1.length(); right < s2.length(); right++) {
            freq2[s2.charAt(right) -'a']++;
            freq2[s2.charAt(left)-'a']--;
            left++;

            if(Arrays.equals(freq1, freq2)) return true;
        }

        return false;
    }
}
