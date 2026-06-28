class Solution {
    public int maxProfit(int[] prices) {
        // track profit while holding stock, start with 1st elem
        int hold = -prices[0];

        // track profit after selling today, start with 0
        int sold = 0;

        // track profit while awaiting cooldown, start with 0
        int rest = 0;

        // iterate through prices, starting with 1
        for(int i = 1; i < prices.length; i++) {
            // track previously sold price, set to sold
            int previouslySold = sold;

            // update sold to hold + price on ith day
            sold = hold + prices[i];

            // update hold to bigger of itself or rest
                // minus price that day
            hold = Math.max(hold, rest - prices[i]);

            // update rest to bigger of itself and previous sold
            rest = Math.max(rest, previouslySold);
        }

        // return whatever is bigger between sold and rest
        return Math.max(sold, rest);
    }
}
