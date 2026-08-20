/**
* pow(x,n) is a mathematical function to calculate the value of x raised to
* power of n (i.e., x^n)
*
* given a floating-point value x and integer value n, implement myPow(x,n)
* function, which calculates x raised to power n
*
* do not use library functions
*
* to solve this question, we can implement following algo:
*
* 1. convert power to long
*
* 2. if power is neg, replace x to 1 / x and make 
*    power positive
*
* 3. track result, start at 1
*
* 4. iterate while power bigger than 0:
*    -if power is odd, multiply result by x
*    -square x
*    -divide power by 2
*
* 5. return result
*/
class Solution {
    public double myPow(double x, int n) {
        // convert power to a long
        long power = n;

        // if power is neg, replace x to 1/x
            // and make it pos
        if(power < 0) {
            x = 1 / x;
            power = -power;
        }

        // track result, start at 1
        double result = 1;

        // iterate while power bigger than 0
        while(power > 0) {
            // if power odd, multiply result by x
            if(power % 2 == 1) result *= x;

            // square x
            x *= x;

            // halve power
            power /= 2;
        }

        // return result
        return result;
    }
}
