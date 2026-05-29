/**
* given a string s, split s into substrings where every substring is a palindrome
*
* return all possible lists of palindromic substrings
* -return solution in any order
*/
class Solution {
    // helper function to check if a string is palindrome
    private boolean isPalindrome(String s, int left, int right) {
        // iterate until left & right intersect
        while(left < right) {
            // if left & right do not match -> return false
            if(s.charAt(left) != s.charAt(right)) return false;

            // shrink from left & right
            left++;
            right--;
        }

        // all characters match
        return true;
    }

    // helper function to backtrack recursively
    private void backtrack(String s,
                            int start,
                            List<String> current,
                            List<List<String>> result) {
        // if start reaches end of string -> palindrome formed
        if(start == s.length()) {
            // add current partition to result
            result.add(new ArrayList<>(current));

            // stop
            return;
        }

        // iterate through string, starting from end of partition
        for(int end = start; end < s.length(); end++) {
            // check if current string is palindrome
            if(isPalindrome(s, start, end)) {
                // add substring to current partition
                current.add(s.substring(start, end + 1));

                // explore future possibilities
                backtrack(s, end + 1, current, result);

                // undo choice
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        // create list to hold result
        List<List<String>> result = new ArrayList<>();

        // call helper function
        backtrack(s, 0, new ArrayList<>(), result);

        // return resulting list
        return result;
    }
}
