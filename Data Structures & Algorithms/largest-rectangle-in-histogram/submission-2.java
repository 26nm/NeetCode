class Solution {
    /**
    * we are given an array of integers heights where heights[i] represents
    * height of a bar (width of each bar is 1)
    *
    * return area of largest rectangle that can be formed among the bars
    *
    * to solve this, we can use a monotonic stack to store boundaries:
    * 1. make a deque to store indices
    *
    * 2. iterate through heights:
    *    -calculate current height
    *    -while stack not empty and current height shorter than height at top
    *     -get height at index of top most element
    *     -set left boundary as -1 or top most element
    *     -calculate width as i - leftBoundary - 1
    *     -calculate area as height * width
    *     -update maxArea
    *
    * 3. push current index to stack
    *
    * 4. return maxArea
    */
    public int largestRectangleArea(int[] heights) {
        // init variables
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // iterate through heights
        for(int i = 0; i <= heights.length; i++) {
            // get current height and perform boundary check
            int currHeight = (i == heights.length) ? 0 : heights[i];

            // update area while stack not empty and height is shorter than top height
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
