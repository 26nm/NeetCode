/**
* we are given an array of distinct integers nums and a target integer target
*
* return a list of all unique combinations of nums where the chosen numbers
* sum to target
* -same number may be chosen from nums an unlimited number of times
*
* to solve this question, we can implement the following algorithm:
* 1. create a list to hold result
*
* 2. if target = 0 -> add combination to result, stop
*    -if target becomes negative -> stop
*
* 3. iterate through nums starting from index:
*    -choose current candidate
*    -reuse same candidate
*    -undo choice
*
* 4. return resulting list
*/
class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index,
                            int target,
                            int[] nums,
                            List<Integer> combination) {
        // if target becomes 0 -> valid combination found, add to result and stop
        if(target == 0) {
            // add to result
            result.add(new ArrayList<>(combination));

            // stop
            return;
        }

        // if target becomes negative -> invalid, stop
        if(target < 0) return;

        // iterate through nums starting from index
        for(int i = index; i < nums.length; i++) {
            // choose current num
            combination.add(nums[i]);

            // reuse candidate
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
