class Solution {
    /**
    * we are given an integer array nums
    *
    * find all triplets such that they sum to 0
    * -duplicates NOT allowed
    *
    * we could:
    * 1. init:
    *    -List<List<Integer>> result = new ArrayList<>();
    * 
    * 2. sort array
    *
    * 3. loop 0 to end of nums:
    *    -skip dupes around nums[i] if needed
    *
    *    -init left to i + 1, right to nums.length - 1
    *
    *    -while(left < right):
    *     -compute sum = nums[i] + nums[left] + nums[right]
    *     -if sum is 0;
    *      -store triplets in result (Arrays.asList(nums[i], nums[left], nums[right]));
    *      -while(left < right && nums[left] == nums[left + 1]): left++;
    *      -while(left < right && nums[right] == nums[right - 1]): right--;
    *      -increment left, decrement right
    *     -otherwise if sum is negative, increment left
    *     -otherwise decrement right
    *
    * 4. return the result
    */
    public List<List<Integer>> threeSum(int[] nums) {
        // init variables and sort array
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // iterate 0 to end of nums
        for(int i = 0; i < nums.length; i++) {
            // skip dupes for nums[i] if needed
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // init left and right
            int left = i + 1, right = nums.length - 1;

            // iterate until l and r meet
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // if sum is 0, adjust pointers to move past dupes and update
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                // increment left if sum negative 
                } else if(sum < 0) {
                    left++;

                // decrement right if sum too small
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
