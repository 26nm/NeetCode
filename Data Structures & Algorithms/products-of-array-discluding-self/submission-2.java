class Solution {
    /**
    * we are given an int array
    *
    * we are asked to return an int array
    * whose contents (arr[i]) are products
    * of every index except for index itself
    *
    * example:
    * input: [1, 2, 4]
    * 
    * should return:
    * [8, 4, 2]
    *
    * we could make two passes
    * 1. create new array result (result[0] = 1)
    * 2. each index = product of previous in result and nums
    * 3. we make second pass to multiply from the right:
         -store result in a suffix (init to 1)
         -result[i] is itself times this suffix
         -update the suffix to itself times element at current
          index in nums
      4. return this result
    */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        // first pass to multiply from left
        for(int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        // second pass to multiply from right;
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
