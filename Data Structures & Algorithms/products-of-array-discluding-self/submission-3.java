class Solution {
    /**
    * we are given an int array
    *
    * we are asked to return an array in which
    * all elements are products of each element
    * multiplied by each other, except the index
    * itself
    *
    * to solve this, we could:
    * 1. declare a new int[] result
    *    -initialize first element to 1 (IMPORTANT!)
    *    -iterate through nums[] from 1 to end:
    *     -result[i] = nums[i - 1] * result[i - 1];
    *
    * 2. declare a new integer suffix (init to 1)
    *
    * 3. iterate nums[] again, this time from the right
    *    -from the end to 0
    *    -result[i] *= suffix;
    *    -suffix *= nums[i];
    *
    * 4. return this result
    */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        // first pass: multiply from left
        for(int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        // second pass: multiply from right
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
