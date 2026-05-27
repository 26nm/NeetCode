/**
* we are given an integer n
*
* return all well-formed parentheses strings you can generate with n
* pairs of parentheses
*
* to solve this question, we might consider the following algorithm:
* 1. if current string length is exactly n * 2 -> add to result, stop
*
* 2. if # of open parentheses < n -> add open 
*    -if # of closed parentheses < open -> add closed
*
* 3. return resulting list
*/
class Solution {
    // helper function to backtrack recursively
    private void backtrack(
        List<String> result,
        String current,
        int open,
        int closed,
        int n
    ) {
        // check if string is exactly n * 2 long
        if(current.length() == n * 2) {
            // valid string, add to result
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
                closed,
                n
            );
        }

        // if # of closed parentheses < open -> add closed
        if(closed < open) {
            backtrack(
                result,
                current + ")",
                open,
                closed + 1,
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
