class Solution {
    /**
    * we are given an int array of heights representing elevation
    * -each value height[i] represents height of a bar, with width 1
    *
    * return max area of rain water that can be trapped between the bars
    *
    * to solve this, we can use two pointers
    *
    * we could:
    * 1. init left to 0, right to 0, water to 0,
    *    maxLeft to 0, maxRight to 0
    *
    * 2. while(left < right):
    *    -if height[left] < height[right]
    *     -if(height[left] > maxLeft)
    *      maxLeft = height[left]
    *     water += maxLeft - height[left];
    *     increment left
    *    -if not, check height on right side
    *     -if(height[right] > maxRight)
    *      -maxRight = height[right]
    *     -water += maxLeft - height[right]
    *     -decrement right
    *
    *  3. return stored result in water
    */
    public int trap(int[] height) {
        // init variables
        int left = 0, right = height.length - 1, water = 0;
        int leftMax = 0, rightMax = 0;

        // iterate til l and r meet
        while(left < right) {
            // check height of rain water
            if(height[left] < height[right]) {
                // update max height on left
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                }

                water += leftMax - height[left];
                left++;

            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                }

                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}
