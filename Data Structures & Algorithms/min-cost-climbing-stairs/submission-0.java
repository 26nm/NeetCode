class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // get costs of step 0 and 1
        int first = cost[0];
        int second = cost[1];

        // iterate from step 2 onward
        for(int step = 2; step < cost.length; step++) {
            // compute current cost as cost + smaller of 1st & 2nd
            int current = cost[step] + Math.min(first, second);

            // shift window
            first = second;
            second = current;
        }

        // return smallest of 1st & 2nd
        return Math.min(first, second);
    }
}
