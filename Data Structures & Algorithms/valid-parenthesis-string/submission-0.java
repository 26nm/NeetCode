class Solution {
    public boolean checkValidString(String s) {
        // track min and max # of open parentheses, start with 0
        int leftMin = 0;
        int leftMax = 0;

        // traverse string
        for(char c : s.toCharArray()) {
            // opening encountered
            if(c == '(') {
                // increment min and max # of open parentheses
                leftMin++;
                leftMax++;

            // closing encountered
            } else if(c == ')') {
                // decrement min and max # of open parentheses
                leftMin--;
                leftMax--;

            // wildcard character encountered
            } else {
                // decrement min, increment max
                leftMin--;
                leftMax++;
            }

            // we have too many closing -> invalid
            if(leftMax < 0) return false;

            // we cannot have negative min # of opening
            if(leftMin < 0) leftMin = 0;
        }

        // return whether valid interpretation is still possible
        return leftMin == 0;
    }
}
