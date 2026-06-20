class Solution {
    public int numDecodings(String s) {
        // track 1st answer, start at 1
        int dp1 = 1;

        // track 2nd answer, start at 0
        int dp2 = 0;

        // iterate through string backwards
        for(int i = s.length() - 1; i >= 0; i--) {
            // track current digit, start at 0
            int current = 0;

            // if current char not 0 -> set current to 1st answer
            if(s.charAt(i) != '0') {
                // set current to 1st answer
                current = dp1;

                // check if out of bounds
                if(i + 1 < s.length()) {
                    // if within bounds -> convert char to ascii
                    int value = 
                        (s.charAt(i) - '0') * 10
                        + (s.charAt(i + 1) - '0');

                    // if ascii within 10 to 26 -> set current to itself + 2nd ans
                    if(value >= 10 && value <= 26) current += dp2;
                }
            }

            // shift window
            dp2 = dp1;
            dp1 = current;
        }

        // return leftmost answer
        return dp1;
    }
}
