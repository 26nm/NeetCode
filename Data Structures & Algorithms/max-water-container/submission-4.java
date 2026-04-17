class Solution {
    /**
    * we are given integer array of heights
    * where heights[i] represents height of ith bar
    *
    * we can choose any two bars to form container
    *
    * return max amount of water container to store
    *
    * to solve this we might use two pointers:
    */
    public int maxArea(int[] heights) {
        // init variables
        int left = 0, right = heights.length - 1;
        int maxArea = 0;

        // iterate til left and right meet
        while(left < right) {
            int width = right - left;

            // greedily calculate area by using minimum height
            int area = Math.min(heights[left], heights[right]) * width;
            maxArea = Math.max(maxArea, area);

            // increment left or right depending on which is bigger
            if(heights[left] < heights[right]) {
                left++;

            } else {
                right--;
            }
        }

        return maxArea;
    }
}
