class Solution {
    /**
    * we are given string s consisting of ({[]})
    *
    * input is valid IFF:
    * -1. every open bracket has closed bracket
    * -2. open bracket closed in correct order
    * -3. every close bracket has corresponding open bracket
    *
    * return true if s is valid, false otherwise
    *
    * to solve this, we might use a Stack:
    * 1. create new Stack
    *
    * 2. for each character in s:
    *    -if character is open, add closed to stack
    *    -if character is close, check to see if stack.pop is open
    *     -if stack is empty, return true
    *     -otherwise, return false
    */
    public boolean isValid(String s) {
        // init variables
        Stack<Character> closed = new Stack<>();

        // iterate through end of s
        for(char ch : s.toCharArray()) {
            // check if current char is open 
            if(ch == '[') {
                closed.push(']');

            } else if(ch == '{') {
                closed.push('}');

            } else if(ch == '(') {
                closed.push(')');

            } else {
                if(closed.isEmpty() || closed.pop() != ch) return false;
            }
        }

        return closed.isEmpty();
    }
}
