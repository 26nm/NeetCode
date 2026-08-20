/**
* pow(x,n) is a mathematical function to calculate value of x raised to power of
* n
*
* given a floating-point value x and integer value n, implement myPow(x,n), which
* calculates x raised to n
*
* you may not use built-in library functions
*/
class Solution {
    public double myPow(double x, int n) {
        // convert power to long
        long exponent = n;

        // if exponent is neg -> replace x with 1/x
            // and make exponent positive
        if(exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        // track the result, start at 1
        double result = 1;

        // iterate while exponent bigger than 0
        while(exponent > 0) {
            // if power odd -> multiply result by x
            if(exponent % 2 == 1) result *= x;

            // square x
            x *= x;

            // divide exponent by 2
            exponent /= 2;
        }

        // return result
        return result;
    }
}
