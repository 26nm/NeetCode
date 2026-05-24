class Solution {
    // create list to hold result
    private List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index,
                            int target,
                            int[] candidates,
                            List<Integer> combination) {
        // if target becomes 0 -> valid combination
        if(target == 0) {
            // add combination to resulting list
            result.add(new ArrayList<>(combination));

            // stop
            return;
        }

        // if target becomes negative -> stop
        if(target < 0) return;

        // iterate through candidates, starting from index
        for(int i = index; i < candidates.length; i++) {
            // skip duplicate candidates at same recursion depth
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // choose current candidate
            combination.add(candidates[i]);

            // explore future possibilities
            backtrack(i + 1, target - candidates[i], candidates, combination);

            // undo choice
            combination.remove(combination.size() - 1);
        }

    }

    // main function
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort input array
        Arrays.sort(candidates);

        // call helper function
        backtrack(0, target, candidates, new ArrayList<>());

        // return resulting list
        return result;
    }
}
