/**
* we are given array of integers cost where cost[is] is the cost of
* taking a step from ith floor of staircase
* -after paying cost, you can step to either (i+1)th floor or (i+2)th floor
* -can start from index 0 or index 1
*
* return the minimum cost to reach top of staircase (i.e., just past
* last index in cost)
*
* to solve this question, we can consider following algo:
* 1. get cost of steps 0 & 1
*
* 2. iterate from step 2 onward:
*    -compute current cost as itself + smallest of 1st & 2nd
*    -shift step window
*
* 3. return smallest cost of 1st & 2nd step
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // get cost of steps 0 & 1
        int first = cost[0];
        int second = cost[1];

        // iterate from step 2 onward
        for(int step = 2; step < cost.length; step++) {
            // calc current cost as itself + smallest of 1st & 2nd
            int current = cost[step] + Math.min(first, second);

            // shift window
            first = second;
            second = current;
        }

        // return smallest cost of 1st & 2nd steps
        return Math.min(first, second);
    }
}
