/**
* you are given an integer array prices where prices[i] is price of NeetCoin
* on ith day
*
* you may buy and sell one NeetCoin multiple times within following
* restrictions:
* 1. after selling NeetCoins, cannot buy another on next day (cooldown)
* 2. you may only own at most one NeetCoin at a time
*
* you may complete as many transactions as you like
*
* return max profit you can achieve
*
* to solve this question, we can implement following algorithm:
* 1. track profit while holding stock, set to neg 1st elem in input
*    -track profit after selling today, set to 0
*    -track profit after not selling nor buying, set to 0
*
* 2. iterate through prices, starting with 1
*    -track previously sold amount, set to sold
*    -update hold to sold + price on ith day
*    -update sold to whatever is bigger of itself and rest - price
*     on that day
*    -update rest to whatever is bigger of itself and previously sold
*
* 3. return whatever is bigger of sold and rest
*/
class Solution {
    public int maxProfit(int[] prices) {
        // track profit while holding stock, start with neg 1st elem
        int hold = -prices[0];

        // track profit after selling today, start with 0
        int sold = 0;

        // track profit after not selling nor buying, start with 0
        int rest = 0;

        // iterate through prices, starting with 1
        for(int i = 1; i < prices.length; i++) {
            // track previous amount sold, set to sold
            int prevSold = sold;

            // adjust hold to price that day + sold
            sold = hold + prices[i];

            // adjust sold to whatever is bigger between
                // itself rest - price that day
            hold = Math.max(hold, rest - prices[i]);

            // adjust rest to whatever is bigger between 
                // itself and previously sold
            rest = Math.max(rest, prevSold);
        }

        // return whatever is bigger between sold and rest
        return Math.max(sold, rest);
    }
}
