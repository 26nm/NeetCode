class Solution {
    /**
    * we are given an array of strings representing valid arithmetic
    * expression in Reverse Polish Notation
    *
    * return integer that represents evaluation of expression
    *
    * to solve this, we use a Stack:
    * 1. declare Deque<Integer> result
    *
    * 2. iterate through tokens:
    *    -if operator is "+", pop stack twice and push
    *    -if operator is "-", pop stack twice, store in variables, push back
    *    -if operator is "*", same as addition
    *    -if operator is "/", same as subtraction
    *    -otherwise, parse current integer
    */
    public int evalRPN(String[] tokens) {
        // init variables
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through tokens
        for(String token : tokens) {
            // check is token is "+"
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());

            // check if token is "-"
            } else if(token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);

            // check if token is "*"
            } else if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            // check if token is "/"
            } else if(token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);

            // parse current integer
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
