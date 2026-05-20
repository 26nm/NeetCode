class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // create a set to track matching indices
        Set<Integer> matched = new HashSet<>();

        // traverse each triplet
        for(int[] triplet : triplets) {
            // check for invalid triplets
            if(triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
                    continue;
            }

            // match target positions
            for(int i = 0; i < 3; i++) {
                // mark matching target indices as achievable
                if(triplet[i] == target[i]) {
                    matched.add(i);
                }
            }
        }

        // return whether all 3 indices become achievable
        return matched.size() == 3;
    }
}
