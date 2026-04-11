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
            char l = lower.charAt(left);
            char r = lower.charAt(right);

            // check for non-alphanumeric characters
            if(!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            // compare characters
            if(l != r) { return false; }

            left++;
            right--;
        }

        return true;
    }
}
