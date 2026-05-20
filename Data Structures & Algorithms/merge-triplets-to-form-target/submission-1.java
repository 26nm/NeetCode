/**
* we are given 2D array of integers triplets, where triplets[i] =
* [ai, bi, ci] represents ith triplet
* -also given array of integers target = [x, y, z] which is triplet
*  we want to obtain
* -to obtain target, we may apply the following operation on triplets
*  zero or more times:
*   -choose 2 different triplets triplets[i] and triplets[j] and update 
*    triplets[j] to become [max(ai,aj), max(bi,bj) and max(ci,cj)]
*
* return true if it is possible to obtain target as an element of triplets
* false otherwise
*
* to solve this question, we can implement the following algorithm:
* 1. create set to track matching indices
*
* 2. traverse through triplets:
*    -skip over invalid triplets
*    -scan for matching indices and add to set
*
* 3. return whether the set contains exactly 3 elements
*/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // create set to hold matching indices
        Set<Integer> matching = new HashSet<>();

        // traverse through triplets
        for(int[] triplet : triplets) {
            // skip over invalid triplets
            if(triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
               continue; 
            }

            // add matching indices to set
            for(int i = 0; i < 3; i++) {
                if(triplet[i] == target[i]) {
                    matching.add(i);
                }
            }
        }

        // return whether the set contains exactly 3 elements
        return matching.size() == 3;
    }
}
