class Solution {
    public int rob(int[] nums) {
        // track best for both houses, start at 0
        int rob1 = 0;
        int rob2 = 0;

        // iterate through houses
        for(int money : nums) {
            // calc robbery amount and avoid adjacent houses
            int current = Math.max(rob1 + money, rob2);

            // shift window
            rob1 = rob2;
            rob2 = current;
        }

        // return robbery amount from 2nd house
        return rob2;
    }
}
