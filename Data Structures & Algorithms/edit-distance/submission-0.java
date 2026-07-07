class Solution {
    public int minDistance(String word1, String word2) {
        // track lengths of both input strings
        int m = word1.length();
        int n = word2.length();

        // create dp array of size n+1
        int[] dp = new int[n + 1];

        // initialize dp array with base case: dp[j] = n - j
        for(int j = 0; j <= n; j++) {
            dp[j] = n - j;
        }

        // iterate through word1 from right to left
        for(int i = m - 1; i >= 0; i--) {
            // store prev diagonal value as n in dp
            int prevDiagonal = dp[n];

            // set n in dp as cost of deleting remaining chars
            dp[n] = m - i;

            // iterate through word2 from right to left
            for(int j = n - 1; j >= 0; j--) {
                // store next diagonal value as j in dp
                int temp = dp[j];

                // if i in word1 matches j in word2 -> copy
                    // diagonal value to j in dp
                if(word1.charAt(i) == word2.charAt(j)) 
                    dp[j] = prevDiagonal;

                // otherwise take minimum of inserting, deleting, or replacing
                else dp[j] = 1 + Math.min(
                    prevDiagonal, Math.min(
                        dp[j],
                        dp[j + 1]
                    )
                );

                // set prev diagonal to temp
                prevDiagonal = temp;
            }
        }

        // return 1st elem in dp
        return dp[0];
    }
}
