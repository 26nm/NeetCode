class Solution {
    /**
    * we are given an integer array heights, in which heights[i] represents
    * height of a bar (width is 1)
    *
    * return area of largest rectangle that can be formed
    * 
    * to solve this, we can maintain a monotonic stack:
    * 1. iterate through heights:
    *    -calc currHeight as heights[i] within boundary, otherwise 0
    *    -while stack not EMPTY and current height shorter than height at the top:
    *     -set area to 0
    *     -set left boundary to either -1 or the top of stack
    *     -set width to i - leftBoundary - 1
    *     -update maxHeight to current highest seen so far
    *
    * 2. return this result
    */
    public int largestRectangleArea(int[] heights) {
        // init variables
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through heights
        for(int i = 0; i <= heights.length; i++) {
            // calc current height
            int currHeight = (i == heights.length) ? 0 : heights[i];

            // calculate area while stack not empty and height less than height at top
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
