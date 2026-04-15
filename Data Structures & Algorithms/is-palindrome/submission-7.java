class Solution {
    /**
    * we are given a string
    * 
    * determine if it is palindrome or not
    * -reads the same forward and back
    *
    * ignore non-alphanumerics
    *
    * we can use two pointers:
    * 1. init:
    *    -left = 0
    *    -right = s.length() - 1
    *
    * 2. while left < right:
    *    -while l < r AND character NOT alphanumeric: increment left
    *    -while l < r AND character NOT alphanumeric: increment right
    *    -if current char at l and current char at r do not match:
    *     -return false
    *    -increment l and r
    *
    * 3. return true
    */
    public boolean isPalindrome(String s) {
        // init variables
        int left = 0, right = s.length() - 1;

        // iterate til l and r meet
        while(left < right) {
            // skip non-alphanumerics on left
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // skip non-alphanumerics on right
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // check for mismatched characters
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // increment
            left++;
            right--;
        }

        return true;
    }
}
