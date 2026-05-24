/**
* we are given an array of integers candidates, which may contain duplicates
* -also contains an integer target
*
* return a list of all unique combinations of candidates where chosen
* numbers sum to target
* -each element may only be chosen at most one time
*
* to solve this problem, we can implement following algorithm that 
* processes a sorted input array:
* 1. create list to hold result
*
* 2. if target becomes 0 -> add combination to result list and stop
*    -if target becomes negative -> stop
*
* 3. iterate through candidates, starting from index:
*    -skip duplicate candidates at same recursion depth
*    -choose current candidate
*    -explore future possibilities
*    -undo choice
*
* 4. return resulting list
*/
class Solution {
    // create list to hold result
    private List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index,
                            int target,
                            int[] candidates,
                            List<Integer> combination) {
        // if target becomes 0 -> add combination to result and stop
        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // if target becomes negative -> stop
        if(target < 0) return;

        // iterate through candidates, starting from index
        for(int i = index; i < candidates.length; i++) {
            // skip duplicates at same recursion depth
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
