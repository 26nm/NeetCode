class Solution {
    public int coinChange(int[] coins, int amount) {
        // create dp array of size amount+1
        int[] dp = new int[amount + 1];

        // fill array with values
        Arrays.fill(dp, amount + 1);

        // set 1st element in dp to 0
        dp[0] = 0;

        // iterate amount times, starting at 1
        for(int current = 1; current <= amount; current++) {
            // iterate through each coin
            for(int coin : coins) {
                // if coin fits -> update min
                if(coin <= current) {
                    dp[current] =
                        Math.min(
                            dp[current], 
                            dp[current - coin] + 1
                        );
                }
            }
        }

        // return -1 if dp[amount] never updated, otherwise return amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
