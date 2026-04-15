class Solution {
    public int maxProfit(int[] prices) {
        // init variables
        int minBuy = prices[0], maxProfit = 0;

        // loop from 1 to end of prices
        for(int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
