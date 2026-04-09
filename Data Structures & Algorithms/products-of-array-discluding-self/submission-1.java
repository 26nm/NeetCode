class Solution {
    /**
    * we are given integer array
    *
    * we return an array where every element
    * (outout[i]) is the product of all 
    * elements of nums except nums[i]
    *
    * input: [1, 2, 4, 6]
    * output: [48, 24, 12, 8]
    *
    * nums[0] = nums[1] * nums[2] * nums[3]
    * nums[1] = nums[0] * nums[2] * nums[3]
    * nums[2] = nums[0] * nums[1] * nums[3]
    * nums[3] = nums[0] * nums[1] * nums[2]
    *
    * we could initialize first element to 1
    * since multiplication by 0 results in
    * undefined behavior
    *
    * while we could brute-force it, might be hard
    * to keep track of where pointers point to
    *
    * what if we iterated through the array and
    * stored prefix products in an array?
    *
    * with that squared away, now we need to find some
    * way to access these stored values
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for(int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}  
