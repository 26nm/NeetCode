/**
* given a string s, return the number of substrings within s that are palindromes
* -a palindrome is string that reads same forward and backward
*
* to solve this question, we can consider following algo:
*
* helper:
* 1. track # of palindromes, start at 0
*
* 2. while characters match:
*    -expand from left & right
*    -increment count
*
* 3. return count
*
* main function:
* 1. track # of palindromes, start at 0
*
* 2. iterate through s:
*    -update count to itself + expanding for odd palindrome
*    -update count to itself + expanding for even palindrome
*
* 3. return the count
*/
class Solution {
    // helper function to expand around center
    private int expand(String s, int left, int right) {
        // track count, start at 0
        int count = 0;

        // expand while characters match
        while(left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            // increment count
            count++;

            // expand from left & right
            left--;
            right++;
        }

        // return count
        return count;
    }

    // main function
    public int countSubstrings(String s) {
        // track count, start at 0
        int count = 0;
        
        // iterate through string
        for(int i = 0; i < s.length(); i++) {
            // expand for odd length string
            count += expand(s, i, i);

            // expand for even length string
            count += expand(s, i, i + 1);
        }

        // return count
        return count;
    }
}
