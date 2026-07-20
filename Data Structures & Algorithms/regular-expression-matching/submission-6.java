/**
* you are given an input string s consisting of lowercase english letters
* and a pattern p consisting of enlish letters, as well as '.' and '*' 
* characters
*
* return true if pattern matches entire input string, false otherwise
* - '.' matches any single character
* - '*' matches zero or more of preceding element
*
* to solve this question, we can implement following algorithm:
*
* 1. get lengths of both input strings
*
* 2. create 2d dp boolean array of size (m+1) x (n+1)
*    -set last elem to true
*
* 3. iterate pattern and string from the right:
*    -check if current chars match
*    -if we encounter '*' -> either skip or consume
*     character if possible
*    -otherwise advance both pointers
*
* 4. return 1st elem in dp
*/
class Solution {
    public boolean isMatch(String s, String p) {
        // get lengths of both input strings
        int m = s.length();
        int n = p.length();

        // create 2d dp boolean array of size (m+1) x (n+1)
        boolean[][] dp = new boolean[m + 1][n + 1];

        // set last elem to true
        dp[m][n] = true;

        // traverse pattern and string from right to left
        for(int i = m; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                // check if current chars match
                boolean firstMatch = i < m
                    && ((s.charAt(i) == p.charAt(j)
                    || p.charAt(j) == '.'));

                // if we encounter '*', either skip current char
                    // or consume one if possible
                if(j + 1 < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2]
                        || (firstMatch && dp[i + 1][j]);

                // otherwise advance both pointers
                } else {
                    dp[i][j] = 
                        firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        // return 1st elem in dp
        return dp[0][0];
    }
}
