class Solution {
    /**
    * this is a variation of Two Sum, in which the array input
    * is sorted
    *
    * we are asked to return indices (1-indexed) of two numbers
    * such that they add up to the target value, and index1 < index2
    *
    * we could use a squeeze technique to solve this problem
    *
    * we might:
    * 1. set left to 0, right to nums.length - 1;
    *
    * 2. while(left < right):
    *    -if num[left] + num[right] == target
    *     -return new int {left + 1, right + 1}
    *
    *    -if(num[left] + num[right] > target)
    *     -decrement right pointer
    *
    *    -if(num[left] + num[right] < target)
    *     -increment left pointer
    *
    * 3. since a solution is always guaranteed:
    *    -return new int {1, 1}
    */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        // apply squeeze technique
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }

            if(numbers[left] + numbers[right] > target) {
                right--;
                continue;
            }

            if(numbers[left] + numbers[right] < target) {
                left++;
                continue;
            }

            left++;
            right--;
        }

        return new int[]{1, 1};  
    }
}
