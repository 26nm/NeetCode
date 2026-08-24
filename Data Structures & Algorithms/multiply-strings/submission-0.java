class Solution {
    public String multiply(String num1, String num2) {
        // if either input is "0" return "0"
        if(num1.equals("0") || num2.equals("0")) 
            return "0";

        // get both input string lengths
        int m = num1.length();
        int n = num2.length();

        // create int array of size m+n to hold product
        int[] result = new int[m + n];

        // traverse num1 from right to left
        for(int i = m - 1; i >= 0; i--) {
            // convert current digit in num1 to int
            int digit1 = num1.charAt(i) - '0';

            // for each digit, traverse num2 from right to left
            for(int j = n - 1; j >= 0; j--) {
                // convert current digit in num2 to int
                int digit2 = num2.charAt(j) - '0';

                // multiply the two digits, add product to result
                    // array
                int sum = digit1 * digit2 + result[i + j + 1];

                // store 1s digit at i+j+1, and carry at i+j
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // create StringBuilder
        StringBuilder product = new StringBuilder();

        // set a pointer i to 0
        int i = 0;

        // skip leading 0s
        while(i < result.length && result[i] == 0) {
            i++;
        }

        // convert result array to string
        while(i < result.length) {
            product.append(result[i++]);
        }

        // return final product as string
        return product.toString();
    }
}
