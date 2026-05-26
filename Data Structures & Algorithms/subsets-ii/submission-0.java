class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index, int[] nums, List<Integer> subset) {
        // add current subset to result
        result.add(new ArrayList<>(subset));

        // iterate through nums, starting from index
        for(int i = index; i < nums.length; i++) {
            // skip duplicate choices at same level
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // choose current element
            subset.add(nums[i]);

            // explore future choices
            backtrack(i + 1, nums, subset);

            // undo choice
            subset.remove(subset.size() - 1);
        }
    }

    // main function
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort input array
        Arrays.sort(nums);

        // call helper function
        backtrack(0, nums, new ArrayList<>());

        // return resulting list
        return result;
    }
}
