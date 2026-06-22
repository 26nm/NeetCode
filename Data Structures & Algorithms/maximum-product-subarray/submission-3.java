/**
* given integer array nums, find subarray that has largest product, and
* return product
* -a subarray is contiguous non-empty sequence of elements within array
* -you can assume output will fit into 32-bit integer
*
* product of an array with single element is value of that element
*
* to solve this question, we can use following algo:
* 1. track current max product, start at 1st elem
*    -track current min product, start at 1st elem
*    -track result, also start at 1st elem
*
* 2. iterate through nums, starting at 1:
*    -get current number at index
*    -track previous max, set to max product
*    -update max product
*    -update min product
*    -update result
*
* 3. return result
*/
class Solution {
    public int maxProduct(int[] nums) {
        // track current max product, start at 1st elem
        int maxProduct = nums[0];

        // track current min product, start at 1st elem
        int minProduct = nums[0];

        // track result, start at 1st elem
        int result = nums[0];

        // iterate through nums, starting from 1
        for(int i = 1; i < nums.length; i++) {
            // get current number
            int num = nums[i];

            // track previous max product, set to max product
            int prevMax = maxProduct;

            // update max product
            maxProduct = 
                Math.max(
                    num,
                    Math.max(
                        maxProduct * num,
                        minProduct * num
                    )
                );

            // update min product
            minProduct = 
                Math.min(
                    num,
                    Math.min(
                        prevMax * num,
                        minProduct * num
                    )
                );

            // update result
            result = Math.max(result, maxProduct);
        }

        // return resulting product
        return result;
    }
}
