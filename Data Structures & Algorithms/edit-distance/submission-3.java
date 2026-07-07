/**
* you are given two strings word1 and word2, each consisting of lowercase english
* letters
*
* you can perform 3 operations on word1 an unlimited # of times:
* 1. insert a char at any position
* 2. delete a char at any position
* 3. replace a char at any position
*
* return min # of operations to make word1 equal word2
*
* to solve this question, we can implement following algorithm:
* 1. get lengths of both input strings (set as m and n, respectively)
*
* 2. create a dp array of size n+1
*    -initialize each slot with base case: dp[j] = n - j
*
* 3. iterate through word1, from right to left:
*    -store previous diagonal value, set this to n in dp
*    -set n in dp as cost to insert remaining chars (m - i)
*    -iterate through word2, from right to left:
*     -copy current diagonal value for later, store this as dp[j]
*     -if i in word1 matches j in word2 -> copy diagonal to j in dp
*     -otherwise set j in dp to minimum of inserting, replacing, or deleting
*
* 4. update previous diagonal
*
* 5. return 1st elem in dp
*/
class Solution {
    public int minDistance(String word1, String word2) {
        // track lengths of both input strings
        int m = word1.length();
        int n = word2.length();

        // create dp array of size n+1
        int[] dp = new int[n + 1];

        // initialize dp with base case: dp[j] = n - j
        for(int j = 0; j <= n; j++) {
            dp[j] = n - j;
        }

        // iterate through word1, from right to left
        for(int i = m - 1; i >= 0; i--) {
            // track prev diagonal value, set this to n in dp
            int prevDiag = dp[n];

            // update n in dp to cost of inserting remaining chars
            dp[n] = m - i;

            // iterate through word2, from right to left
            for(int j = n - 1; j >= 0; j--) {
                // copy diagonal value for later, set as j in dp
                int temp = dp[j];

                // if i in word1 matches j in word2 -> update j in dp
                    // to the diagonal value
                if(word1.charAt(i) == word2.charAt(j)) dp[j] = prevDiag;

                // otherwise update dp[j] to min of inserting, replacing, deleting
                else dp[j] = 1 + Math.min(
                    prevDiag, Math.min(
                        dp[j], dp[j + 1]
                    )
                );

                // update prev diagonal to temp
                prevDiag = temp;
            }
        }

        // return 1st elem in dp
        return dp[0];
    }
}
