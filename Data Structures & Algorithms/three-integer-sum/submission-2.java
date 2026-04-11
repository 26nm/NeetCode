class Solution {
    /**
    * we are given an integer array
    *
    * we are asked to return all triplets within
    * such that they add up to 0
    *
    * no duplicate triplets allowed
    *
    * we could use two pointers to find a pair (nums[j], nums[k])
    * for every nums[i]
    *
    * we could:
    * 1. declare List<List<Integer>> result
    *
    * 2. sort nums[]
    *
    * 3. iterate 0 through end of nums:
    *    -skip duplicates for nums[i]
    *    -initialize left to nums[i + 1], right to the end
    *    -while (left < right):
    *     -compute sum = nums[i] + nums[left] + nums[right]
    *      -if sum is 0, result.add(Arrays.asList(nums[i], nums[left], nums[right]))
    *       -check for dupes within left and right:
    *       -while(left < right && nums[left] == nums[left + 1]) left++;
    *       -while(left < right && nums[right] == nums[right - 1]) right--;
    *     -else, if sum < 0
    *      -increment left
    *      -otherwise, decrement right
    *
    * 4. return this result;  
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // iterate thru nums
        for(int i = 0; i < nums.length; i++) {
            // skip dupes
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // init pointers
            int left = i + 1;
            int right = nums.length - 1;

            // iterate until both meet
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // check for dupes
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } else if(sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
