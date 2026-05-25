class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int[] nums,
                            boolean[] used,
                            List<Integer> permutation) {
        // full permutation formed
        if(permutation.size() == nums.length) {
            // add permutation to result array
            result.add(new ArrayList<>(permutation));

            // stop
            return;
        }

        // iterate through nums
        for(int i = 0; i < nums.length; i++) {
            // skip already used numbers
            if(used[i]) continue;

            // choose current number and marked as used
            used[i] = true;
            permutation.add(nums[i]);

            // explore future possibilities
            backtrack(nums, used, permutation);

            // undo choice
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    // main function
    public List<List<Integer>> permute(int[] nums) {
        // create boolean array to track which nums already used
        boolean[] used = new boolean[nums.length];

        // call helper function
        backtrack(nums, used, new ArrayList<>());

        // return resulting list
        return result;
    }
}
