class Solution {
    /**
    * we are given a string
    * 
    * determine if it is palindrome or not
    * -reads the same forward and back
    *
    * ignore non-alphanumerics
    *
    * we can use two pointers
    */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
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
