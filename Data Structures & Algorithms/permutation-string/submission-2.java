class Solution {
    /**
    * we are given two strings s1 and s2
    *
    * return true if s2 contains a permutation of s1, false otherwise
    *
    * to solve this, we can use char frequencies and sliding window 
    *
    * we could:
    * 1. return false if s1 longer than s2
    *
    * 2. calculate char freq arrays for both s1 and s2
    *    -if char freqs match, return true
    *
    * 3. decrement char freqs in both arrays
    *    -if char freqs match, return true
    *
    * 4. return false
    */
    public boolean checkInclusion(String s1, String s2) {
        // return false immediately if s1 longer
        if(s1.length() > s2.length()) return false;

        // calculate char freqs
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freq1, freq2)) return true;

        int left = 0;

        // decrement char freqs in both arrays
        for(int right = s1.length(); right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;
            left++;

            if(Arrays.equals(freq1, freq2)) return true;
        }

        return false;
    }
}
