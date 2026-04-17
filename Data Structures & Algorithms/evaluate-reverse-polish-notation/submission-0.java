class Solution {
    /**
    * we are given array of strings representing valid
    * arithmetic expression in Reverse Polish Notation
    *
    * return integer that represents evaluation of expression 
    * -operands may be integers or results of other ops
    * -operators include '+', '-', '*', and '/'
    * -assume that division between integers always truncates toward zero
    *
    * input: ["1", "2", "+", "3", "*", "4", "-"]
    * output: 5
    * ((1 + 2) * 3) - 4 = 5
    *
    * could we perhaps parse the string backwards?
    *
    * we might create a stack to store operands
    *
    * then depending on current string, we parse
    */
    public int evalRPN(String[] tokens) {
        // init variables
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through tokens
        for(String token : tokens) {
            // check if current token is "+"
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());

            // check if current token is "-"
            } else if(token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);

            // check if current token is "*"
            } else if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            // check if current token is "/"
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
