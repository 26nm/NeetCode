class Solution {
    // create letters to digits mapping
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
        // if current string length = digits string length -> add combo to result
        if(current.length() == digits.length()) {
            // add current combo to result
            result.add(current.toString());

            // stop
            return;
        }

        // get equivalent letters from phone digit
        String letters = phone[digits.charAt(index) - '0'];

        // iterate through letters
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

        // if digits is empty string -> return empty list
        if(digits.length() == 0) return result;

        // call helper function
        backtrack(digits, 0, new StringBuilder(), result);

        // return resulting list
        return result;
    }
}
