class Solution {
    public boolean isMatch(String s, String p) {
        // track lengths of both input strings, set as m and n respectively
        int m = s.length();
        int n = p.length();

        // create 2d dp boolean array of size m+1 x n+1
        boolean[][] dp = new boolean[m + 1][n + 1];

        // set very end to true
        dp[m][n] = true;

        // traverse pattern and string from right to left
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // determine whether current chars match
                boolean firstMatch = i < m 
                    && (s.charAt(i) == p.charAt(j) 
                    || (p.charAt(j) == '.'));

                // if next pattern char is * -> either
                // skip it or consume one char if possible
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);

                    // otherwise advance both pointers if chars match
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        // return 1st elem in dp
        return dp[0][0];
    }
}
