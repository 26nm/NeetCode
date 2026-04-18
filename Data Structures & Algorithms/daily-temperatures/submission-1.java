class Solution {
    /**
    * we are given array of integers temperatures where temperatures[i]
    * represents the daily temperatures on the ith day
    *
    * return array result where result[i] is number of days after the ith day before
    * a warmer temperature appears on future day (set to 0 if none)
    *
    * to solve this, we maintain a monotonic decreasing stack:
    * 1. init variables
    *
    * 2. loop through temperatures:
    *    -while stack is not empty and current temperature bigger than the top:
    *     -calculate the difference between current and prev
    *     -push this result to the stack
    *    -add i to the stack
    *
    * 3. return the result
    */
    public int[] dailyTemperatures(int[] temperatures) {
        // init variables
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // iterate through temperatures
        for(int i = 0; i < n; i++) {
            // maintain decreasing order and calc differences in temperature
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }

            stack.push(i);
        }

        return result;
    }
}
