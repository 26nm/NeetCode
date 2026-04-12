class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        // iterate until both pointers meet
        while(left < right) {
            // check rainwater height on left
            if(height[left] < height[right]) {
                // update max height for left side
                if(height[left] >= leftMax) {
                    leftMax = height[left];

                } else {
                    // water height is minimum of tallest bar on left minus own height
                    water += leftMax - height[left];
                }

                // adjust left
                left++;

            } else {
                // update rainwater height for right side, if needed
                if(height[right] >= rightMax) {
                    rightMax = height[right];

                } else {
                    // calculate water height for right side
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}
