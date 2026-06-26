/**
* given an integer array nums, return length of longest strictly increasing
* subsequence
* -subsequence is sequence that can be derived from given sequence by
*  deleting some or no elements without changing relative order of
*  remaining characters
*
* to solve this question, we can implement following algo:
* 1. create list tails to store "smallest end values" of sequences
*
* 2. iterate through nums:
*    -track left ptr, start at 0
*    -track right ptr, start at end of tails
*    -perform binary search:
*     -if mid in tails < nums -> adjust left to mid + 1
*     -otherwise adjust right to mid
*    -if left reaches end of tails -> add current num to tails
*     -otherwise override existing value with current num
*
* 3. return size of tails
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        // create list to hold smallest end values
        List<Integer> tails = new ArrayList<>();

        // iterate through nums
        for(int num : nums) {
            // track left ptr, start at 0
            int left = 0;

            // track right ptr, start at end of tails
            int right = tails.size();

            // perform binary search to find 1st num >= tail
            while(left < right) {
                // calc middle value
                int mid = left + (right - left) / 2;

                // if mid in tails < num -> set left to mid + 1
                if(tails.get(mid) < num) left = mid + 1;

                // otherwise set right to mid
                else right = mid;
            }

            // if left ptr reaches end of tails -> add current num to tails
            if(left == tails.size()) tails.add(num);

            // otherwise override existing value with current num
            else tails.set(left, num);
        }

        // return size of tails
        return tails.size();
    }
}
