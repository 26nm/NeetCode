class Solution {
    public int climbStairs(int n) {
        // if n less than/equal to 2 -> return n
        if(n <= 2) return n;

        // climb stair 1 step at time
        int first = 1;

        // climb stair 2 steps at time
        int second = 2;

        // iterate from stair 3 to n
        for(int stair = 3; stair <= n; stair++) {
            // calc current stair
            int current = first + second;

            // set first to second
            first = second;

            // set second to current
            second = current;
        }

        // return second step
        return second;
    }
}
