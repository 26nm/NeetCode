class MinStack {
    /**
    * this is a class design problem
    *
    * we design a stack class to support push, pop, top,
    * and getMin
    *
    * we can start by using a stack to store minimum values
    * and a primary stack
    *
    * for push, we might consider adding to the primary stack
    * and the minimum stack
    * -maybe add the minimum of top element and element being added 
    *  to the min stack?
    *
    * for pop, we could just pop the primary stack
    * -but what about updating minimum values?
    */

    // init variables
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
    * constructor
    */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        // add element to main stack and update minStack with minimum value
        stack.push(val);

        if(minStack.isEmpty()) {
            minStack.push(val);

        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
