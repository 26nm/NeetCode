class Solution {
    public int[] plusOne(int[] digits) {
        // iterate from right to left
        for(int i = digits.length - 1; i >= 0; i--) {
            // if current digit less than 9, increment by 1
                // and return array
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // set current digit to 0
            digits[i] = 0;
        }

        // make new array of size input's length plus one to
            // hold sum
        int[] result = new int[digits.length + 1];

        // set 1st elem to 1
        result[0] = 1;

        // return resulting array
        return result;
    }
}
