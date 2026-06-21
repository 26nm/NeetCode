/**
* we are given integer array coins representing coins of different
* denominations (e.g., 1 dollar, 5 dollars, etc) and integer amount
* representing target amount of money
*
* return fewest coins needed to make exact target amount
* -return -1 if impossible
*
* to solve this question, we can consider following algo:
* 1. create dp array of size amount + 1
*
* 2. fill array with values (amount + 1 to represent inf)
*    -set 1st element in dp to 0
*
* 3. iterate through each amount:
*    -iterate through each coin:
*     -if coin fits within current amount:
*      -update current in dp to min of current and prev coin + 1
*
* 4. return -1 if dp[amount] not updated, otherwise return amount
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        // create dp array of size amount + 1
        int[] dp = new int[amount + 1];

        // fill array with values (amount + 1 to represent inf)
        Arrays.fill(dp, amount + 1);

        // set 1st element to 0
        dp[0] = 0;

        // iterate through each amount
        for(int current = 1; current <= amount; current++) {
            // iterate through each coin
            for(int coin : coins) {
                // if coin fits amount -> update minimum
                if(coin <= current) {
                    dp[current] =
                        Math.min(
                            dp[current],
                            dp[current - coin] + 1
                        );
                }
            }
        }

        // return -1 if dp[amount] not updated, otherwise its value
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
