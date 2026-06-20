/**
* a string consisting of uppercase letters can be encoded to a number using the
* following mapping:
* A -> 1
* B -> 2
* . . .
* Z -> 26
*
* to decode, digits must be grouped and then mapped back into letters
* -leading 0s are invalid
*
* given a string containing only digits, return number of ways to decode it
* -answer fits in 32-bit integer
*
* to solve this question, we can consider following algo:
* 1. track 1st answer (start at 1), 2nd answer (start at 0)
*
* 2. iterate through string backwards:
*    -track current digit (start at 0)
*    -if current char is NOT 0:
*     -set current to 1st answer
*     -check if i+1 within bounds:
*      -if yes, calculate ascii
*      -if ascii within 10 and 26:
*       -adjust current to itself + 2nd ans
*    -shift window
*
* 3. return 1st answer
*/
class Solution {
    public int numDecodings(String s) {
        // track 1st answer, start at 1
        int dp1 = 1;

        // track 2nd answer, start at 0
        int dp2 = 0;

        // iterate through string backward
        for(int i = s.length() - 1; i >= 0; i--) {
            // track current digit, start at 0
            int current = 0;

            // if current char not 0 -> set current to 1st ans
            if(s.charAt(i) != '0') {
                // set current to 1st answer
                current = dp1;

                // check if i+1 within bounds
                if(i + 1 < s.length()) {
                    // if so -> turn char into ascii value
                    int value = 
                        (s.charAt(i) - '0') * 10
                        + (s.charAt(i + 1) - '0');

                    // if ascii within 10 & 26 -> update current to itself + 2nd ans
                    if(value >= 10 && value <= 26) current += dp2;
                }
            }

            // shift window
            dp2 = dp1;
            dp1 = current;
        }

        // return 1st answer
        return dp1;
    }
}
