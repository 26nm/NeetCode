class Solution {
    /**
    * we are given two integer arrays nums1 and nums2 of size m and n
    * respectively, each sorted in ascending order
    *
    * find median value of both
    *
    * to solve this, we perform binary search on partitions:
    * 1. ensure that nums1 is smaller than nums2
    *
    * 2. initialize variables
    *    -int m -> nums1.length
    *    -int n -> nums2.length
    *    -int total -> m + n
    *    -int left -> 0
    *    -int right -> m
    *
    * 3. iterate until left and right intersect:
    *    -calc partition indices i and j
    *    -calc left and right bounds for both arrays
    *    -check if partition for both arrays is valid
    *     -if it is, see if combined length is odd
    *     -if so, return max of left bounds for both arrays
    *     -otherwise, take average of each bound
    *
    * 4. if left bound for 1st array bigger than right bound for 2nd
    *    -shrink from right
    *    -otherwise shrink from left
    *
    * 5. return 0.0 to handle edge cases
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ensure nums1 is shorter than nums2
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // init variables
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        
        int left = 0;
        int right = m;

        // iterate until left and right intersect
        while(left <= right) {
            // calculate partition indices i and j
            int i = left + (right - left) / 2;
            int j = (total + 1) / 2 - i;

            // calculate left and right bounds for both arrays
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // check if partition for both arrays is valid
            if(left1 <= right2 && left2 <= right1) {
                // if so, check if combined length odd
                if(total % 2 != 0) {
                    // return bigger of left bounds from both arrays
                    return Math.max(left1, left2);

                // average bounds across both arrays
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            }

            // if left bound from 1st array bigger than right bound from 2nd array, shrink right
            if(left1 >= right2) {
                right = i - 1;

            // shrink from left
            } else {
                left = i + 1;
            }
        }

        // handle edge-cases
        return 0.0;
    }
}
