class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index, int[] nums, List<Integer> subset) {
        // mark current subset as valid
        result.add(new ArrayList<>(subset));

        // iterate through nums starting at index
        for(int i = index; i < nums.length; i++) {
            // choose current element
            subset.add(nums[i]);

            // explore future choices
            backtrack(i + 1, nums, subset);

            // undo choice
            subset.remove(subset.size() - 1);
        }
    }

    // main function
    public List<List<Integer>> subsets(int[] nums) {
        // call helper function
        backtrack(0, nums, new ArrayList<>());

        // return resulting list
        return result;
    }
}
