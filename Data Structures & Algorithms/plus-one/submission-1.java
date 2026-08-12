/**
* you are given an integer array digits, where each digits[i] is the ith digit of
* a large integer
*
* it is ordered from most significant to least significant, and it will not contain
* any leading zero
* 
* return the digits of given integer after incrementing it by one
*
* to solve this question, we can implement following algorithm:
*
* 1. traverse input from right to left:
*    -if current digit less than 9, increment by one and return input
*    -otherwise set current digit to 0
*
* 2. create new array of size input length plus one
*    -set 1st elem to 1
*
* 3. return resulting array
*/
class Solution {
    public int[] plusOne(int[] digits) {
        // traverse from right to left
        for(int i = digits.length - 1; i >= 0; i--) {
            // if current digit less than 9, increment by one
                // and return input
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // otherwise set current digit to 0 to carry
            digits[i] = 0;
        }

        // create new array of size input length plus one to hold sum
        int[] result = new int[digits.length + 1];

        // set 1st elem to 1
        result[0] = 1;

        // return resulting array
        return result;

    }
}
