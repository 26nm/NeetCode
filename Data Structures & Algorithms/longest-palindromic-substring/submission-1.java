/**
* we are given string s, return longest substring of s that is palindrome
*
* to solve this question, we can consider following algo:
*
* helper:
* 1. while characters are matching:
*    -expand from the left and right
*
* 2. return right - left - 1 (valid substring length)
*
* main function:
* 1. track start and end, start at 0 for both
*
* 2. iterate through string:
*    -expand around center for odd & even palindromes
*    -get whatever is bigger (set this as length)
*    -if length is bigger than what's seen so far:
*     -adjust start to before current center
*     -adjust end to after current center
*
* 3. return substring from start to end + 1
*/
class Solution {
    // helper function to expand from center
    private int expandAroundCenter(String s, int left, int right) {
        // expand while characters match
        while(left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            // expand from left & right
            left--;
            right++;
        }

        // return length of most recent valid substring
        return right - left - 1;
    }

    // main function
    public String longestPalindrome(String s) {
        // track start and end, start at 0
        int start = 0;
        int end = 0;

        // iterate through string
        for(int i = 0; i < s.length(); i++) {
            // expand around center for odd string length
            int odd = expandAroundCenter(s, i, i);

            // expand around center for even string length
            int even = expandAroundCenter(s, i, i + 1);

            // get length of substring
            int len = Math.max(odd, even);

            // if length bigger than longest so far -> adjust start/end
            if(len > end - start + 1) {
                // adjust start to before current center
                start = i - (len - 1) / 2;

                // adjust end to after current center
                end = i + (len / 2);
            }
        }

        // return substring of current start and end
        return s.substring(start, end + 1);
    }
}
