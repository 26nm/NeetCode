class Solution {
    public int trap(int[] height) {
        // init vatiables
        int left = 0, right = height.length - 1, water = 0;
        int leftMax = 0, rightMax = 0;

        // iterate until left and right meet
        while(left < right) {
            // update the minimum tallest left bar
            if(height[left] < height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                }

                // area is maximum height minus its own height 
                water += leftMax - height[left];
                left++;

            // update the minimum tallest right bar
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                }

                // area is maximum height minus its own height
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}
