class Solution {
    // helper function to backtrack recursively
    private void backtrack(
        List<String> result,
        String current,
        int open,
        int close,
        int n
    ) {
        // valid combo found
        if(current.length() == n * 2) {
            // add current string to result
            result.add(current);

            // stop
            return;
        }

        // if # of open parentheses < n -> add open
        if(open < n) {
            backtrack(
                result,
                current + "(",
                open + 1,
                close,
                n
            );
        }

        // if # of closed parentheses < open -> add close
        if(close < open) {
            backtrack(
                result,
                current + ")",
                open,
                close + 1,
                n
            );
        }
    }

    // main function
    public List<String> generateParenthesis(int n) {
        // create list to hold result
        List<String> result = new ArrayList<>();

        // call helper function
        backtrack(result, "", 0, 0, n);

        // return resulting list
        return result;
    }
}
