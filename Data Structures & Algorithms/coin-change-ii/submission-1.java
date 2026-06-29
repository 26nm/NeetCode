/**
* you are given an integer array coins representing different coins of different
* denominations (e.g., 1 dollar, 5 dollars, etc) and an integer amount representing
* a target amount of money
*
* return number of distinct combinations totaling to amount
* -if impossible to make amount, return 0
* -you may assume you have unlimited amount of each coin
*
* to solve this question, we can implement following algorithm:
* 1. make dp array of size amount+1
*    -set 1st elem to 1
*
* 2. iterate through each coin:
*    -iterate through each amount, starting at coin:
*     -set current in dp to itself plus current minus coin in dp
*
* 3. return amount in dp
*/
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
                // update current in dp to itself + current - coin in dp
                dp[current] += dp[current - coin];
            }
        }

        // return amount in dp
        return dp[amount];
    }
}
