class Solution {
    public int lengthOfLIS(int[] nums) {
        // create dp array as long as nums
        int[] dp = new int[nums.length];

        // fill array with 1s
        Arrays.fill(dp, 1);

        // track longest sequence so far, start with 1
        int longest = 1;

        // iterate through nums backwards
        for(int i = nums.length - 1; i >= 0; i--) {
            // iterate through indices after current index i
            for(int j = i + 1; j < nums.length; j++) {
                // if j in nums > i in nums -> update i in dp
                    // to whatever is bigger between i in dp
                    // and j in dp + 1
                if(nums[j] > nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            // update longest seen so far
            longest = Math.max(longest, dp[i]);
        }

        // return longest lis
        return longest;
    }
}
