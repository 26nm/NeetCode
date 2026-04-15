class Solution {
    /**
    * this is a variation of Two Sum
    * -input array is sorted
    *
    * since array is sorted, we can use two pointers
    * to apply squeeze technique
    *
    * 1. init:
    *    -left = 0
    *    -right = nums.length - 1
    *
    * 2. while l < r:
    *    -calculate sum = num[left] + num[right]
    *    -if sum matches target:
    *     -return new int[]{left + 1, right + 1}
    *    -else if sum is bigger:
    *     -decrement right
    *     -otherwise increment left
    *
    * 3. return empty array
    */
    public int[] twoSum(int[] numbers, int target) {
        // init variables
        int left = 0, right = numbers.length - 1;

        // iterate until l and r meet
        while(left < right) {
            // compute sum
            int sum = numbers[left] + numbers[right];

            // return index pairs (1-indexed)
            if(sum == target) {
                return new int[]{left + 1, right + 1};

            // decrement right if sum bigger than target
            } else if(sum > target) {
                right--;

            // otherwise increment left
            } else {
                left++;
            }
        }

        return new int[]{};
    }
}
