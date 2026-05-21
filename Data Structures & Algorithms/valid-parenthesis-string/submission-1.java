/**
* we are given a string s which contains only 3 types of characters:
* ['(', ')', '*']
*
* return true if s is valid, otherwise return false
*
* string is said to be valid if:
* 1. every left parenthesis has a right and vice versa
* 2. left comes before right
* 3. string could contain a wildcard ('*'), which could
*    be a left, right, or empty string
*
* to solve this question, we can implement following algorithm:
* 1. track min and max # of open parentheses, start at 0
*
* 2. traverse through string:
*    -if opening encountered, increment min and max
*    -if closing encountered, decrement min and max
*    -if wildcard encountered, decrement min, increment max
*    -if max # of opens is negative, we have too many closings -> invalid
*    -if min # of opens negative, set it to 0
*
* 3. return whether # of opens and closed balanced
*/
class Solution {
    public boolean checkValidString(String s) {
        // track min and max # of open parentheses, start at 0
        int minOpen = 0;
        int maxOpen = 0;

        // traverse string
        for(char ch : s.toCharArray()) {
            // opening encountered
            if(ch == '(') {
                // increment min and max
                minOpen++;
                maxOpen++;

            // closing encountered
            } else if(ch == ')') {
                // decrement min and max
                minOpen--;
                maxOpen--;

            // wildcard encountered
            } else {
                // decrement min # of opens
                minOpen--;

                // increment max # of opens
                maxOpen++;
            }

            // if max # of opens becomes negative -> we have too many closings, invalid
            if(maxOpen < 0) return false;

            // if min # of opens becomes negative -> set to 0, we can't have negative 0
            if(minOpen < 0) minOpen = 0;
        }

        // return whether # of opens and closed successfully balanced
        return minOpen == 0;
    }
}
