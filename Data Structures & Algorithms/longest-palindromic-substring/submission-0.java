class Solution {
    // helper function to expand around center
    private int expandAroundCenter(String s, int left, int right) {
        // iterate while characters match
        while(left >= 0 &&
            right < s.length() &&
            s.charAt(left) == s.charAt(right)) {
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
            // expand around odd center
            int odd = expandAroundCenter(s, i, i);

            // expand around even center
            int even = expandAroundCenter(s, i, i + 1);

            // get string length
            int len = Math.max(odd, even);

            // if length bigger than substring -> adjust start & end
            if(len > end - start + 1) {
                // adjust start to before current center
                start = i - (len - 1) / 2;

                // adjust end to after current center
                end = i + len / 2;
            }
        }

        // return substring from start to end
        return s.substring(start, end + 1);
    }
}
