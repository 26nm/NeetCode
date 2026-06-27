/**
* given two strings text1 and text2, return length of longest common
* subsequence between two strings if one exists, return 0 otherwise
* -subsequence is a sequence that can be derived from given sequence
*  by deleting some or no elements without changing relative order
*  of remaining characters
*
* to solve this question, we can implement the following algorithm:
* 1. create dp array of size text2's length + 1
*
* 2. iterate through text1 backwards:
*    -create new row, represented as array (size text2's length + 1)
*    -iterate through text2 backwards:
*     -if i in text1 matches j in text2 -> update j in current to
*      j in dp + 1 + next diagonal in dp
*     -otherwise update j in current to whatever is bigger between
*      j in dp and next diagonal in current
*
* 3. update dp to current to clear old row
*
* 4. return 1st element in dp
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // create dp array of size text2's length + 1
        int[] dp = new int[text2.length() + 1];

        // iterate through text1 backwards
        for(int i = text1.length() - 1; i >= 0; i--) {
            // create new row
            int[] current = new int[text2.length() + 1];

            // iterate through text2 backwards
            for(int j = text2.length() - 1; j >= 0; j--) {
                // if chars match, update current[j] to
                    // 1 + dp[j + 1]
                if(text1.charAt(i) == text2.charAt(j)) {
                    current[j] = 1 + dp[j + 1];
                }

                // otherwise, update current[j] to whichever
                    // has longer substring length
                else {
                    current[j] = Math.max(dp[j], current[j + 1]);
                }
            }

            // clear old row
            dp = current;
        }

        // return 1st element in dp
        return dp[0];
    }
}
