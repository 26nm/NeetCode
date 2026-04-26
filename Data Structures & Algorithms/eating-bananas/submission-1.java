class Solution {
    /**
    * we are given an integer array piles where piles[i] represents # of bananas
    * in ith pile
    * -we also given integer h, which represents number of hoours given to eat
    *  all bananas
    *
    * we can choose banana eat rate of k
    *
    * find the minimum eat rate k such that we can eat all bananas
    *
    * within h hours
    *
    * to solve this, we can perform binary search on answer space:
    * 1. set left -> 1, right -> 0
    *
    * 2. update right -> highest pile of bananas
    *
    * 3. while left <= right:
    *    -calc current eat rate k -> left + (right - left) / 2
    *    -compute number of hours needed -> hours += (piles + k - 1) / k
    *    -adjust eat rate depending on whether hours exceeds h
    *  
    * 4. return left
    */
    public int minEatingSpeed(int[] piles, int h) {
        // init variables
        int left = 1, right = 0;

        // find highest pile of bananas
        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        // iterate until left and right meet
        while(left <= right) {
            // calc current eat rate k
            int k = left + (right - left) / 2;

            int hours = 0;

            // calc # of hours to eat the pile
            for(int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            // adjust eat rates (works, try to lower)
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
