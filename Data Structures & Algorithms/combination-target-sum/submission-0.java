class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index, 
                            int target, 
                            int[] nums, 
                            List<Integer> combination) {
        // if target becomes 0 -> valid combination found
        if(target == 0) {
            // add combination to result and stop
            result.add(new ArrayList<>(combination));
            return;
        }

        // if target becomes negative -> invalid combination, stop
        if(target < 0) return;

        // iterate through candidates starting at index
        for(int i = index; i < nums.length; i++) {
            // choose current candidate
            combination.add(nums[i]);

            // reuse same candidate
            backtrack(i, target - nums[i], nums, combination);

            // undo choice
            combination.remove(combination.size() - 1);
        }

    }

    // main function
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // call helper function
        backtrack(0, target, nums, new ArrayList<>());

        // return resulting list
        return result;
    }
}
