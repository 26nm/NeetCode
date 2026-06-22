class Solution {
    public int maxProduct(int[] nums) {
        // track current max product, start at 1st element
        int maxProduct = nums[0];

        // track current min product, start at 1st element
        int minProduct = nums[0];

        // track result, start at 1st element
        int result = nums[0];

        // iterate through nums, starting at 1
        for(int i = 1; i < nums.length; i++) {
            // get current number at i
            int num = nums[i];

            // track previous max, set to max product
            int prevMax = maxProduct;

            // update max product to whatever is bigger
                // between current number and whatever is
                // bigger between max product x n and
                // min product x n
            maxProduct = 
                Math.max(
                    num,
                    Math.max(
                        maxProduct * num,
                        minProduct * num
                    )
                );

            // update min product to whatever is smaller
                // between current number and whatever is
                // smaller between prev max x n and
                // min product x n
            minProduct = 
                Math.min(
                    num,
                    Math.min(
                        prevMax * num,
                        minProduct * num
                    )
                );

            // set result to whatever is bigger between itself and max product
            result = Math.max(result, maxProduct);
        }

        // return resulting product
        return result;
    }
}
