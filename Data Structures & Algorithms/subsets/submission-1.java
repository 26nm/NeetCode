/**
* we given an array of unique integers nums
*
* return all possible subsets of nums
* -do not include duplicate subsets
*
* to implement this function, we might consider the following algorithm:
* 1. create a list to hold result
*
* 2. add current subset to result
*
* 3. iterate through nums starting at current index:
*    -choose current subset
*    -explore future choices
*    -undo choice
*
* 4. return resulting list
*/
class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper function to backtrack recursively
    private void backtrack(int index, int[] nums, List<Integer> subset) {
        // add current subset to result
        result.add(new ArrayList<>(subset));

        // iterate through nums, starting at index
        for(int i = index; i < nums.length; i++) {
            // choose current subset
            subset.add(nums[i]);

            // explore future possibilities
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
