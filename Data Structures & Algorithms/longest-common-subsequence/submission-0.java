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
                // if characters in both texts match -> set j
                    // in dp to 1 + next diagonal to the right
                    // in dp
                if(text1.charAt(i) == text2.charAt(j)) {
                    current[j] = 1 + dp[j + 1];
                }

                // otherwise set j in current to max of itself and next
                    // diagonal in current row
                else {
                    current[j] = Math.max(dp[j], current[j + 1]);
                }
            }

            // set dp to current to replace current row
            dp = current;
        }

        // return 1st element in dp
        return dp[0];
    }
}
