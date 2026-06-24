/**
* given an integer array nums, return length of longest strictly increasing
* subsequence
* -subsequence is sequence that can be derived from given sequence by
*  deleting some or no elements without changing relative order of
*  remaining characters
*
* to solve this question, we can implement following algorithm:
* 1. create dp array of size nums
*    -fill array with 1s
*
* 2. track longest increasing subsequence, start at 1
*
* 3. iterate through nums backwards
*    -iterate through indices to the right of i:
*     -if j in nums bigger than i in nums ->
*       update i in dp to whatever is bigger
*       between i in dp and j in dp + 1
*
* 4. update longest sequence
*
* 5. return longest
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        // create dp array of size nums
        int[] dp = new int[nums.length];

        // fill array with 1s
        Arrays.fill(dp, 1);

        // track longest sequence seen so far, start at 1
        int longest = 1;

        // iterate through nums backwards
        for(int i = nums.length - 1; i >= 0; i--) {
            // iterate through indices to the right of i
            for(int j = i + 1; j < nums.length; j++) {
                // if j in nums > i+1 in nums ->
                    // update i in dp to whatever is
                    // bigger between that and j in dp + 1
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // update longest sequence
            longest = Math.max(longest, dp[i]);
        }

        // return longest sequence
        return longest;
    }
}
