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

        // return # of palindromes
        return count;
    }

    // main function
    public int countSubstrings(String s) {
        // track # of palindromes, start at 0
        int count = 0;

        // iterate through string
        for(int i = 0; i < s.length(); i++) {
            // expand around center for odd strings
            count += expand(s, i, i);

            // expand around center for even strings
            count += expand(s, i, i + 1);
        }

        // return # of palindromes
        return count;
    }
}
