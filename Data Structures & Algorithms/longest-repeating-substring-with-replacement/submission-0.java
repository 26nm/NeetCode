class Solution {
    public int characterReplacement(String s, int k) {
        // init variables
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        // iterate through string
        for(int right = 0; right < s.length(); right++) {
            // calculate char freqs and find the max
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // calculate length within valid window
            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)- 'A']--;
                left++;
            }

            // update max length seen so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
