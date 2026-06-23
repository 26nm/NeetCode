/**
* given a string s and dictionary of strings wordDict, return true if s
* can be segmented into space-separated sequence of dictionary words
*
* you can resuse words in dictionary an unlimited number of times
* -you may assume all dictionary words are unique
*
* to solve this question, we can implement following algo:
* 1. create boolean dp array of size string length + 1
*    -set last element to true
*
* 2. iterate through string backwards:
*    -iterate through word dict:
*     -if word fits, substring matches, remaining suffix valid
*      mark current position true
*     -if string already segmented -> stop
*
* 3. return boolean at beginning of array
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // create boolean dp array of size string length + 1
        boolean[] dp = new boolean[s.length() + 1];

        // set last element to true
        dp[s.length()] = true;

        // iterate through string backwards
        for(int i = s.length() - 1; i >= 0; i--) {
            // iterate through word dict
            for(String word : wordDict) {
                // if word fits, substring matches, remaining
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

        // return 1st element
        return dp[0];
    }
}
