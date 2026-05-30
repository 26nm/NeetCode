/**
* we are given a string digits made up of digits from 2-9 inclusive
* -each digit (not including 1) is mapped to set of characters
* -digit could represent any one of the characters it maps to
*
* return all possible letter combinations that digits could represent
* -return in any order
*
* to solve this question, we can consider the following approach:
* 1. map each digit to letter combinations
*
* 2. if current string length matches input string length -> add combo
*    to result and stop
*
* 3. get equivalent letter combo from input digit string
*
* 4. iterate through letter combo:
*    -choose current letter
*    -explore future possibilities
*    -undo choice
*
* 5. return resulting list
*/
class Solution {
    // map each digit to letter combinations
    private final String[] phone = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };

    // helper function to backtrack recursively
    private void backtrack(String digits,
                            int index,
                            StringBuilder current,
                            List<String> result
    ) {
        // if current string length matches input's -> add combo to result
        if(current.length() == digits.length()) {
            // add current combo to result
            result.add(current.toString());

            // stop
            return;
        }

        // get letter combination from phone #
        String letters = phone[digits.charAt(index) - '0'];

        // iterate through letter combination
        for(char ch : letters.toCharArray()) {
            // choose current char
            current.append(ch);

            // explore future possibilities
            backtrack(digits, index + 1, current, result);

            // undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }

    // main function
    public List<String> letterCombinations(String digits) {
        // create list to hold result
        List<String> result = new ArrayList<>();

        // if input is empty -> return empty list
        if(digits.length() == 0) return result;

        // call helper function
        backtrack(digits, 0, new StringBuilder(), result);

        // return resulting list
        return result;
    }
}
