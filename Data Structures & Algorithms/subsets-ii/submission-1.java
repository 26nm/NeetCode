/**
* we are given an array nums of integers, which may contain duplicates
*
* return all possible subsets
* -solution must not contain duplicate subsets
* -return solution in any order
*
* to solve this question, we should consider following algorithm (sort input 1st):
* 1. add current subset to result
*
* 2. iterate through nums, starting from index:
*    -skip over dupes at same recursion depth
*    -choose current number
*    -explore future possiblities
*    -undo choice
*
* 3. return resulting list
*/
class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index, int[] nums, List<Integer> subset) {
        // add current subset to result
        result.add(new ArrayList<>(subset));

        // iterate through nums, starting from index
        for(int i = index; i < nums.length; i++) {
            // skip dupes at same recursive depth
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // choose current number
            subset.add(nums[i]);

            // explore future possibilities
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
