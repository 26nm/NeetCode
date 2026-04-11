class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // start at fixed element
        for(int i = 0; i < nums.length; i++) {
            // skip dupes for i
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // initialize pointers
            int left = i + 1;
            int right = nums.length - 1;

            // iterate until pointers meet(find triplets)
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // check triplets
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip dupes for left and right
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                    // adjust pointers accordingly
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
