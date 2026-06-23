class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // create boolean dp array of size string length + 1
        boolean[] dp = new boolean[s.length() + 1];

        // set last element in array to true
        dp[s.length()] = true;

        // iterate through string backwards
        for(int i = s.length() - 1; i >= 0; i--) {
            // iterate through word dict
            for(String word : wordDict) {
                // if word fits, substring matches, and remaining
                    // suffix valid, mark current position true
                if(i + word.length() <= s.length()
                    && s.startsWith(word, i)) {
                    // mark current position true
                    dp[i] = dp[i + word.length()];
                }

                // if string already segmented -> stop
                if(dp[i]) break;
            }
        }

        // return value at beginning
        return dp[0];
    }
}
