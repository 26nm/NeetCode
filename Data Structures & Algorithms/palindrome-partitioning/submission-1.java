/**
* given a string s, split s into substrings where every substring is
* palindrome
*
* return all possible lists of palindromic substrings
* -return solution in any order
*
* to solve this question, we can consider a 3-phase approach:
* 1. implement a helper function to determine if a string is a palindrome
*
* 2. if current index in string reaches the end -> palindrome formed
*    -add partition to current
*    -stop
*
* 3. iterate through rest of string:
*    -if the current string is palindrome:
*     -choose current partiton
*     -explore future possibilities
*     -undo choice
*
* 4. return resulting list
*/
class Solution {
    // helper function to check if a string is palindromic
    private boolean isPalindrome(String s, int left, int right) {
        // iterate until left & right intersect
        while(left < right) {
            // check if characters differ
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
        // if we reach end of string -> palindrome formed
        if(start == s.length()) {
            // add current partition to result
            result.add(new ArrayList<>(current));

            // stop
            return;
        }

        // iterate through string, start from end of partition
        for(int end = start; end < s.length(); end++) {
            // check if current partition is palindromic
            if(isPalindrome(s, start, end)) {
                // choose current partition
                current.add(s.substring(start, end + 1));

                // explore future possibilities
                backtrack(s, end + 1, current, result);

                // undo choice
                current.remove(current.size() - 1);
            }
        }
    }

    // main function
    public List<List<String>> partition(String s) {
        // create list to hold result
        List<List<String>> result = new ArrayList<>();

        // call helper function
        backtrack(s, 0, new ArrayList<>(), result);

        // return resulting list
        return result;
    }
}
