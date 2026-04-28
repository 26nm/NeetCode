class Solution {
    /**
    * we are given two integer arrays nums1 and nums2, of size m and
    * n respectively
    * -each is sorted in ascending order
    *
    * return median value
    *
    * would this be a case of... nope, makes the space O(N)
    *
    * nums1 -> [1, 2] nums2 -> [3]
    * median: 2
    *
    * nums1 -> [1, 3] nums2 -> [2, 4]
    * median: (2 + 3) / 2 = 2.5
    *
    * nums1 -> [1, 3, 5] nums2 -> [2, 6]
    * median: 3
    *
    * there has to be some trick to some how treat both as one
    * array without requiring auxilliary data structures...

    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ensure nums1 smaller than nums2
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // init variables
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int left = 0;
        int right = m;

        // iterate until left and right meet
        while(left <= right) {
            // calc partition indices i and j
            int i = left + (right - left) / 2;
            int j = (total + 1) / 2 - i;

            // calc boundary positions
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // check if partition is valid
            if(left1 <= right2 && left2 <= right1) {
                // check if combined length is odd
                if(total % 2 == 1) {
                    // return bigger element of num1's and num2's left bound
                    return Math.max(left1, left2);

                // average left and right bounds from both arrays
                } else {
                    return (Math.max(left1, left2) +
                            Math.min(right1, right2)) / 2.0;
                }
            }

            // left bound of 1st array bigger than right bound of 2nd array
            if(left1 >= right2) {
                // shrink right
                right = i - 1;

            // shrink from left
            } else {
                left = i + 1;
            }
        }

        // edge-case handling
        return 0.0;
    }
}
