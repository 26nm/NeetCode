class Solution {
    /**
    * we are given a string
    *
    * we are asked to determine if it is a palindrome
    * -palindrome are strings that read the same
    *  forward and backward
    *
    * we might use two pointers to scan from the left and right
    *
    * we could:
    * 1. set left to 0, right to s.length() - 1
    *
    * 2. while (left < right):
    *    -skip over alphanumeric characters
    *     -advance left and right until alphanumeric is reached (if necessary)
    *    -if (lowercase) characters at left and right pointers at any point mismatch, return false
    *    -otherwise, advance left and right
    *
    * 3. return true
    */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        // iterate until both points cross
        while(left < right) {
            // ignore alphanumerics
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
