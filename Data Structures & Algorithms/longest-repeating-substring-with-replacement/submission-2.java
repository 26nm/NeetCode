class Solution {
    /**
    * we are given a string s and an integer k
    *
    * after performing at most k replacements,
    * find length of longest substring containing only
    * one distinct character
    *
    * to solve this, we could use Sliding Window
    *
    * we might:
    * 1. iterate 0 to end of s:
    *    -find character frequency
    *    -find the maximum frequency
    *
    * 2. calculate length within valid window
    *
    * 3. update maxLength seen so far
    *
    * 4. return maxLength
    */
    public int characterReplacement(String s, int k) {
        // init variables
        int[] freqs = new int[26]; 
        int left = 0, maxLen = 0;
        int maxFreq = 0;

        // iterate through s
        for(int right = 0; right < s.length(); right++) {
            freqs[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqs[s.charAt(right) - 'A']);

            // calculate length within valid window
            while((right - left + 1) - maxFreq > k) {
                freqs[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
