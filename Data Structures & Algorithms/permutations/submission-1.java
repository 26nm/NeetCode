/**
* we are given an array nums of unique integers
*
* return all possible permutations
* -you may return answer in any order
*
* to solve this question, we can implement following algorithm:
* 1. create list to hold result
*
* 2. if permutations list size matches input array size:
*    -add permutation to resulting list
*    -stop
*
* 3. iterate through nums:
*    -if num already used (tracked with boolean arr) -> continue
*    -choose current num and mark as used
*    -explore future possibilities
*    -undo choice
*
* 4. return resulting list
*/
class Solution {
    // create list to hold result
    List<List<Integer>> result = new ArrayList<>();

    // helper method to backtrack recursively
    private void backtrack(boolean[] used,
                            int[] nums,
                            List<Integer> permutation) {
        // full permutation formed
        if(permutation.size() == nums.length) {
            // add permutation to result and stop
            result.add(new ArrayList<>(permutation));
            return;
        }

        // iterate througn nums
        for(int i = 0; i < nums.length; i++) {
            // if num already used -> skip
            if(used[i]) continue;

            // choose current num and mark as used
            used[i] = true;
            permutation.add(nums[i]);

            // explore future possibilities
            backtrack(used, nums, permutation);

            // undo choice
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }

    }

    // main function
    public List<List<Integer>> permute(int[] nums) {
        // create boolean array to track used nums
        boolean[] used = new boolean[nums.length];

        // call helper function
        backtrack(used, nums, new ArrayList<>());

        // return resulting list
        return result;
    }
}
