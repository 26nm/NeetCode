class Solution {
    /**
    * we are given an integer array representing height
    * for "bars" of water
    *
    * return the maximum amount of water container can store
    *
    * height is determined by the "shorter bar" of two bars
    *
    * we could solve this using two pointers
    *
    * we could:
    * 1. init left to 0, right to end of heights, maxArea to 0
    *
    * 2. while(left < right):
    *    -int width = right - left;
    *    -int area = (Math.min(heights[left], heights[right]) * width);
    *    -maxArea = Math.max(maxArea, area)
    *    -if left height shorter than right height, increment left
    *    -otherwise decrement right
    *
    * 3. return the maxArea
    */
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;

        // loop til pointers meet
        while(left < right) {
            int width = Math.max(left, right) - Math.min(left, right);
            int area = (Math.min(heights[left], heights[right])) * width;
            maxArea = Math.max(maxArea, area);

            if(heights[left] < heights[right]) {
                left++;

            } else {
                right--;
            }
        }

        return maxArea;
    }
}
