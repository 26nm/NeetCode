class Solution {
    /**
    * we are given two integer arrays nums1 and num2 of size m and n respectively
    * -each is sorted in ascending order
    *
    * return median among all elements of both arrays
    *
    * to solve this question, we must perform binary search on a valid partition
    * -we use the smaller array as some sort of reference:
    *
    * 1. ensure that nums1 is smaller than nums2
    *
    * 2. initialize variables:
    *    -m -> nums1.length
    *    -n -> nums2.length;
    *    -total -> m + n;
    *    -left -> 0
    *    -right -> m
    *
    * 2. iterate until left and right intersect:
    *    -calculate partition indices
    *    -calculate left and right boundaries for each array
    *    -check if partition is valid for both arrays
    *     -if total length of both arrays odd, return bigger of left bound
    *      from both arrays
    *     -otherwise average all boundary values
    *
    *   -if left bound from 1st array bigger than right bound from second
    *    -shrink from right side
    *    -otherwise shrink from left
    *
    * 3. return 0.0 to handle edge cases
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

        // iterate until left and right intersect
        while(left <= right) {
            // calc partition indices i and j
            int i = left + (right - left) / 2;
            int j = (total + 1) / 2 - i;

            // calc left and right bounds for both arrays
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // check if partition valid for both arrays
            if(left1 <= right2 && left2 <= right1) {
                // check if total length is odd
                if(total % 2 == 1) {
                    return Math.max(left1, left2);

                // average all boundaries
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            }

            // left bound from 1st array bigger than right bound from 2nd array
            if(left1 >= right2) {
                // shrink from right
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
