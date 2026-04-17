class Solution {
    /**
    * we are given a string s consisting of "()[]{}"
    * 
    * s if valid IFF:
    * 1. every open bracket has a corresponding closed
    *
    * 2. open brackets closed in correct order
    *
    * 3. every closed bracket has corresponding open
    *
    * return true if all these conditions are met, false otherwise
    *
    * to solve this, we can use a Stack:
    * 1. create new stack
    * 
    * 2. for each char in s:
    *    -if open bracket encountered, push closed one in stack
    *    -if it's empty OR current character doesn't match most recent, false
    *
    * 3. return whether stack is empyu;
    */
    public boolean isValid(String s) {
        // init variables
        Stack<Character> closed = new Stack<>();

        // iterate thru s
        for(char ch : s.toCharArray()) {
            if(ch =='(') { closed.push(')'); }
            else if(ch == '[') { closed.push(']'); }
            else if(ch == '{') { closed.push('}'); }
            else if(closed.isEmpty() || closed.pop() != ch ) return false;
        }

        return closed.isEmpty();
    }
}
