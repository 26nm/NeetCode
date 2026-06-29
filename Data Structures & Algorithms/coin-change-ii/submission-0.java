class Solution {
    public int change(int amount, int[] coins) {
        // create dp array of size amount + 1
        int[] dp = new int[amount + 1];

        // set 1st elem to 1
        dp[0] = 1;

        // iterate through each coin
        for(int coin : coins) {
            // iterate through each amount, starting from coin
            for(int current = coin; current <= amount; current++) {
                // set current in dp to itself + current minus coin in dp
                dp[current] += dp[current - coin];
            }
        }

        // return amount in dp
        return dp[amount];
    }
}
