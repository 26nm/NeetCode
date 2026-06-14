/**
* we are given an intger n representing # of steps to reach top of staircase
* -can climb either 1 or 2 steps at time
*
* return # of distinct ways to climb top of staircase
*
* to solve this question, we can consider following algo:
* 1. if n <= 2 -> return n
*
* 2. track variable first to represent 1 step at time (set to 1)
*    -track variable second to represent 2 steps at time (set to 2)
*
* 3. iterate from 3rd stair to n:
*    -calc current stair as 1st + second
*    -set 1st to second
*    -set 2nd to current
*
* 4. return 2nd (most recent step)
*/
class Solution {
    public int climbStairs(int n) {
        // if n <= 2 -> return n
        if(n <= 2) return n;

        // track 1st and 2nd steps
        int first = 1;
        int second = 2;

        // iterate from 3rd step to n
        for(int stair = 3; stair <= n; stair++) {
            // calc current step as 1st + 2nd
            int current = first + second;

            // adjust step window
            first = second;
            second = current;
        }

        // return 2nd step (most recent)
        return second;
    }
}
