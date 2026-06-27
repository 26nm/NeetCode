/**
* given two strings text1 and text2, return length of longest common
* subsequence between two strings if one exists, otherwise return 0
* -a subsequence is sequence that can be derived from given sequence
*  by deleting some or no elements without changing relative order of
*  remaining characters
*
* to solve this question, we can implement following algorithm:
* 1. create dp array of size text2's length + 1
*
* 2. iterate through text1 backwards:
*    -create new row of size text's length + 1
*    -iterate through text2 backwards:
*     -if characters match -> set j in dp to 1 + next diagonal
*      in dp (to the right)
*     -otherwise set j in current to max of itself or next
*      diagonal in current
*
* 3. update dp to current row to clear old row
*
* 4. return 1st element in dp
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // create dp array of size text2's length + 1
        int[] dp = new int[text2.length() + 1];

        // iterate through text1 backwards
        for(int i = text1.length() - 1; i >= 0; i--) {
            // create new row of size text2's length + 1
            int[] current = new int[text2.length() + 1];

            // iterate through text2 backwards
            for(int j = text2.length() - 1; j >= 0; j--) {
                // if chars in both texts match -> update dp[j]
                    // to 1 + next diagonal to right in dp
                if(text1.charAt(i) == text2.charAt(j)) {
                    current[j] = 1 + dp[j + 1];
                }

                // else update j in current to max of j in dp and
                    // next diagonal in current
                else {
                    current[j] = Math.max(dp[j], current[j + 1]);
                }
            }

            // update dp to current to clear old row
            dp = current;
        }

        // return 1st element in dp
        return dp[0];
    }
}
