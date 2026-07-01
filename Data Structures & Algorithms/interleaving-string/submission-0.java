class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // if s1's and s2's lengths do not add to s3's length
            // return false
        if(s1.length() + s2.length() != s3.length()) return false;

        // create boolean dp array of size s2's length + 1
        boolean[] dp = new boolean[s2.length() + 1];

        // set end of dp array to true
        dp[s2.length()] = true;

        // iterate through s1 backwards
        for(int i = s1.length(); i >= 0; i--) {
            // iterate through s2 backwards
            for(int j = s2.length(); j >= 0; j--) {
                // if we reached end for both strings -> continue
				if(i == s1.length()
				    && j == s2.length()) continue;
                
                // if i within bounds, i in s1 matches
                    // i + j in s3, and j in dp is true,
                    // set j in dp to true
                if(i < s1.length()
                    && s1.charAt(i) == s3.charAt(i + j)
                    && dp[j]) dp[j] = true;

                // else if j within bounds, j in s2 matches
                    // i + j in s3 and
                    // j + 1 in dp is true, set j in dp
                    // to true
                else if(j < s2.length()
                    && s2.charAt(j) == s3.charAt(i + j)
                    && dp[j + 1]) dp[j] = true;

                // else set j in dp to false 
                else dp[j] = false;
            }
        } 

        // return 1st elem in dp
        return dp[0];
    }
}
