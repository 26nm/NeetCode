class Solution {
    /**
    * we are given an int array
    *
    * return the maximum profit
    *
    * to solve this, we could use a greedy approach
    * and a running minimum
    *
    * we could:
    * 1. init maxProfit to 0, minBuy to prices[0]
    *
    * 2. for 1 to end of prices:
    *    -minBuy = Math.min(minBuy, prices[i])
    *    -int profit = prices[i] - minBuy
    *    -maxProfit = Math.max(maxProfit, profit)
    *
    * 3. return maxProfit
    */
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuy = prices[0];

        // calculate best profit
        for(int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
