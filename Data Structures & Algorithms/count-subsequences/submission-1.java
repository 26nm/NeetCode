class Solution {
    public int numDistinct(String s, String t) {
        // track lengths of strings s and t
        int m = s.length();
        int n = t.length();

        // create a dp array of size t's length + 1
        long[] dp = new long[n + 1];

        // set end of dp to 1 (always 1 way to form empty target)
        dp[n] = 1;

        // iterate through s from right to left
        for(int i = m - 1; i >= 0; i--) {
            // store previous value as n in dp
            long prev = dp[n];

            // iterate through t from right to left
            for(int j = n - 1; j >= 0; j--) {
                // store current value before updating as j in dp
                long temp = dp[j];

                // if char at i in s matches char at j in t ->
                    // add number of ways obtained by using
                    // current char
                if(s.charAt(i) == t.charAt(j)) dp[j] += prev;

                // update prev for next iteration
                prev = temp;
            }
        }

        // return 1st elem in dp, casted as an integer
        return (int) dp[0];
    }
}
