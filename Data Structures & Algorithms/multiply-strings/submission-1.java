/**
* you are given two strings num1 and num2 representing non-neg ints
*
* return product of num1 and num2 in a string
* -assume neither num1 nor num2 contain any leading zero, unless they are
*  the number 0 itself
*
* no library functions allowed
*
* to solve this question, we can implement the following algo:
*
* 1. if either input string is 0, return 0
*
* 2. get the lengths of both input strings
* 
* 3. make an int array of size m+n to hold product
*
* 4. traverse num1 from right to left:
*    -convert current digit in num1 to int
*    -traverse num2 from right to left:
*     -convert current digit in num2 to int
*     -multiply both digits together, add result to 
*      result[i + j + 1]
*
*    -store 1s digit in result[i + j + 1], and carry in
*     -result[i+j]
*
* 5. convert int array into string using StringBuilder
*
* 6. return final string
*/
class Solution {
    public String multiply(String num1, String num2) {
        // if either input is "0" return 0
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        // get lengths of both input strings
        int m = num1.length();
        int n = num2.length();

        // create int array of size m+n to hold product
        int[] result = new int[m + n];

        // traverse num1 from right to left
        for(int i = m - 1; i >= 0; i--) {
            // convert current digit in num1 to int
            int digit1 = num1.charAt(i) - '0';

            // traverse num2 from right to left
            for(int j = n - 1; j >= 0; j--) {
                // convert current digit in num2 to int
                int digit2 = num2.charAt(j) - '0';

                // multiply both digits together, add result 
                    // to product array
                int sum = digit1 * digit2 + result[i + j + 1];

                // store 1s digit in i+j+1 and carry in i+j
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // create StringBuilder
        StringBuilder product = new StringBuilder();

        // create pointer i, set to 0
        int i = 0;

        // skip leading 0s
        while(i < result.length && result[i] == 0) {
            i++;
        }

        // add each digit to string
        while(i < result.length) {
            product.append(result[i++]);
        }

        // return final product as string
        return product.toString();
    }
}
