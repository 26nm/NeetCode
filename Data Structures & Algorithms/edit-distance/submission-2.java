/**
* you are given two strings word1 and word2, each consisting of lowercase english
* characters
*
* you can perform 3 operations on word1 unlimited # of times:
* 1. insert char at any position
* 2. delete char at any position
* 3. replace char at any position
*
* return min number of operations to make word1 equal word2
*
* to solve this question, we can implement following algorithm:
* 1. get lengths of both input strings (set to m and n, respectively)
*
* 2. create dp array of size n+1
*    -initialize each slot with n-j (cost to insert remaining chars)
*
* 3. iterate through word1, from right to left:
*    -store previous diagonal value, set to n in dp
*    -set n in dp to m - i
*    -iterate through word2, from right to left:
*     -set temp to j in dp
*     -if i in word1 matches j in word2 -> update j in dp
*      to itself + prev diagonal
*     -else take the minimum of inserting, deleting, and replacing
*    -set previous diagonal to temp
*
* 4. return 1st elem in dp
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
            // store previous diagonal as n in dp
            int prevDiagonal = dp[n];

            // update n in dp to cost of inserting remaining chars
            dp[n] = m - i;

            // iterate through word2 from right to left
            for(int j = n - 1; j >= 0; j--) {
                // store current diagonal value
                int temp = dp[j];

                // if characters match -> update j in dp to previous diagonal
                if(word1.charAt(i) == word2.charAt(j)) dp[j] = prevDiagonal;

                // else update j in dp to min of inserting, deleting, and replacing
                else dp[j] = 1 + Math.min(
                    prevDiagonal, Math.min(
                        dp[j], dp[j + 1]
                    )
                );

                // update prevDiagonal to temp
                prevDiagonal = temp;
            }
        }

        // return 1st elem in dp
        return dp[0];
    }
}
