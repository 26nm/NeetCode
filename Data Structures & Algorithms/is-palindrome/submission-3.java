class Solution {
    /**
    * this is an intro to two pointers
    *
    * we are given a string
    *
    * asked to determine if it's a palindrome:
    * -reads the same forwards and backwards
    *
    * for this, we could:
    * 1. initialize left to 0, right to beginning of string
    *
    * 2. convert the string to all lowercase
    *
    * 3. loop while left < right:
    *    -declare char variables l and r
    *    -if either character is NOT alphanumeric, advance both pointers
    *    -check if pointers have the same char:
    *     -if characters are different, return false
    *     -otherwise, advance both pointers
    *
    * 4. return true
    */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        String lower = s.toLowerCase();

        // iterate through string
        while(left < right) {

            // skip over non-alphanumeric characters
            while(left < right && !Character.isLetterOrDigit(lower.charAt(left))) {
                left++;
            }

            while(right > left && !Character.isLetterOrDigit(lower.charAt(right))) {
                right--;
            }

            char l = lower.charAt(left);
            char r = lower.charAt(right);
            
            // compare characters
            if(l != r) { return false; }

            left++;
            right--;
        }

        return true;
    }
}
