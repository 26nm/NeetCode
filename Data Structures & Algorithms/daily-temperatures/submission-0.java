class Solution {
    /**
    * we are given an array of inteegers temperatures where 
    * temperatures[i] represents the daily temperatures on
    * the ith day
    *
    * return array result where result[i] is the number of days after
    * the ith day before a warmer temperature appears on future day
    * -if there is no day in the future where a warmer temp
    *  will appear, set result[i] to 0
    *
    * input:
    * -temp = [40, 38, 36, 35, 30, 30, 28]
    *
    * output: 
    * -result = [1, 4, 1, 2, 1, 0, 0]
    *
    * how is the output even derived?
    */
    public int[] dailyTemperatures(int[] temperatures) {
        // init variables
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through temperatures
        for(int i = 0; i < n; i++) {
            // maintain decreasing order
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }

            // add element
            stack.push(i);
        }

        return result;
    }
}
