/**
* given a string s, return the longest substring of s that is palindrome
* -palindrome reads the same forward and backward
*
* to solve this question, we can consider the following algo:
*
* helper:
* 1. while characters match:
*    -shrink from left & right
*
* 2. return right - left - 1 (valid substring length)
*
* main function:
* 1. track start & end, start at 0
*
* 2. iterate through string:
*    -expand for odd length string
*    -expand for even length string
*    -get the length of the substring (max of odd/even)
*    -if length exceeds longest:
*     -adjust start to before current center
*     -adjust end to after current center
*
* 3. return substring of start to end + 1
*/
class Solution {
    // helper function to expand around center
    private int expandAroundCenter(String s, int left, int right) {
        // shrink while characters match
        while(left >= 0 
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            // expand from left & right
            left--;
            right++;
        }

        // return substring length
        return right - left - 1;
    }

    // main function
    public String longestPalindrome(String s) {
        // track start & end, start at 0
        int start = 0;
        int end = 0;

        // iterate through string
        for(int i = 0; i < s.length(); i++) {
            // expand around odd length string
            int odd = expandAroundCenter(s, i, i);

            // expand around even length string
            int even = expandAroundCenter(s, i, i + 1);

            // get length of substring
            int len = Math.max(odd, even);

            // if length bigger than longest so far -> adjust start and end
            if(len > end - start + 1) {
                // adjust start to before current center
                start = i - (len - 1) / 2;

                // adjust end to after current center
                end = i + (len / 2);
            }
        }

        // return length of current substring
        return s.substring(start, end + 1);
    }
}
