class Solution {
    /**
    * we are given array of integers heights in which heights[i] is height
    * of a bar (width of each bar is 1)
    *
    * return the area of largest rectangle that can be formed among bars
    *
    * input: [1, 3, 7]
    *
    * output: 7
    */
    public int largestRectangleArea(int[] heights) {
        // init variables
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // iterate through heights
        for(int i = 0; i <= heights.length; i++) {
            // calculate current height
            int currHeight = (i == heights.length) ? 0 : heights[i];

            // compute area while stack not empty and height less than height at top
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
