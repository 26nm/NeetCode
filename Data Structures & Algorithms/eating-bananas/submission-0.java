class Solution {
    /**
    * we are given an integer array piles where piles[i] is number of
    * bananas in ith pile
    * -also given an integer h, which represents the number of hours 
    *  you have to eat the bananas
    *
    * return the minimum integer k such that you can eat all the bananas within h hours
    */
    public int minEatingSpeed(int[] piles, int h) {
        // init variables
        int left = 1;
        int right = 0;

        // find max among the piles
        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        // iterate until left and right intersect
        while(left <= right) {
            // calculate current eat rate
            int k = left + (right - left) / 2;

            int hours = 0;

            // compute hours needed
            for(int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            // adjust eat rate (works, but lower it)
            if(hours <= h) {
                right = k - 1;

            // eat rate too slow
            } else {
                left = k + 1;
            }
        }

        // return minimum eat rate
        return left;
    }
}
