class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1; // use two pointers, one to start, one to end
        s = s.toLowerCase(); // normalize string

        while(left < right) { // iterate til both pointers meet each other
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            if(l != r) return false;

            left++;
            right--;
        } 

        return true;
    }
}
