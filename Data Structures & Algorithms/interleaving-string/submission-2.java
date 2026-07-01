/**
* you are given three strings s1, s2, and s3
*
* return true if s3 is formed by interleaving s1 and s2 together or
* false otherwise
*
* interleaving two string s and t is done by dividing s and t into n
* and m substrings respectively, where following conditions hold:
* 1. |n - m| <= 1 (i.e., difference between number of substrings of
*    s and t is at most 1)
* 2. s = s1 + s2 + ... + sn
* 3. t = t1 + t2 + ... + tm
* 4. interleaving s and t is s1 + t1 + s2 + t2 + ... 
*    or t1 + s1 + t2 + s2
*
* you may assume s1, s2, and s3 consist of lowercase English letters
*
* to solve this question, we can implement following algorithm:
* 1. if s1's and s2's lengths do not add up to s3's length -> return false
*
* 2. create boolean dp array of size s2's length + 1
*    -set end of dp array to true
*
* 3. iterate through s1 backwards:
*    -iterate through s2 backwards:
*     -if we reached end of both strings -> stop
*     -if i within bounds of s1, i in s1 matches
*      i + j in s3, and dp[j] is true -> set dp[j]
*      to true
*     -else if j within bounds of s2, j in s2 matches
*      i + j in s3, and dp[j + 1] is true -> set dp[j]
*      to true
*     -else set dp[j] to false
*
* 4. return 1st elem in dp
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // if s1's and s2's lengths do not add up to s3's
            // return false
        if(s1.length() + s2.length()
            != s3.length()) return false;

        // create boolean dp array of size s2's length + 1
        boolean[] dp = new boolean[s2.length() + 1];

        // set last element in dp to true
        dp[s2.length()] = true;

        // iterate through s1 backwards
        for(int i = s1.length(); i >= 0; i--) {
            // iterate through s2 backwards
            for(int j = s2.length(); j >= 0; j--) {
                // if we reached end of both strings -> stop
                if(i == s1.length() &&
                    j == s2.length()) continue;

                // if i is within s1, i in s1 matches i + j in s3,
                    // and j in dp is true -> set j in dp to true
                if(i < s1.length()
                    && s1.charAt(i) == s3.charAt(i + j)
                    && dp[j]) dp[j] = true;

                // else if j is within s2, j in s2 matches i + j in s3,
                    // and j + 1 in dp is true -> set j in dp to true
                else if(j < s2.length()
                    && s2.charAt(j) == s3.charAt(i + j)
                    && dp[j + 1]) dp[j] = true;

                // else set dp[j] to false
                else dp[j] = false; 
            }
        }

        // return 1st elem in dp
        return dp[0];
    }
}
