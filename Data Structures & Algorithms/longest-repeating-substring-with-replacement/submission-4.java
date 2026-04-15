class Solution {
    /**
    * we are given string s containing only uppercase characters and int k
    *
    * can choose up to k characters of string to replace
    *
    * return length of longest substring which contains only one distinct character
    *
    * to solve, we might:
    * 1. init variables: 
    *    -maxLength = 0
    *    -int[] maxFreq = new int[26]
    *    -int left = 0, right = 0;
    *
    * 2. find char with highest frequency
    *
    * 3. while(((right - left) + 1) - maxFrequency > k):
    *    -subtract char frequencies?
    */
    public int characterReplacement(String s, int k) {
        // init variables
        int left = 0, maxLength = 0;
        int maxFreq = 0;
        int[] freqs = new int[26];

        // iterate through string, with right pointer
        for(int right = 0; right < s.length(); right++) {
            // calculate char freqs and find the max
            freqs[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqs[s.charAt(right) - 'A']);

            // calculate length within valud window, from left
            while((right - left + 1) - maxFreq > k) {
                freqs[s.charAt(left) - 'A']--;
                left++;
            }

            // update max length seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
