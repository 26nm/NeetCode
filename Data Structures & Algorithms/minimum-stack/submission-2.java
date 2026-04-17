class MinStack {
    /**
    * classic design problem
    *
    * design a stack class with functions push, pop, top, and getMin
    * -all functions should run in O(1) time
    *
    * to solve this, we keep a running minimum stack to always know
    * the minimum element
    */
    private Stack<Integer> primaryStack;
    private Stack<Integer> minStack;

    // init variables
    public MinStack() {
        primaryStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    // add value to primary stack, update minimum in min stack
    public void push(int val) {
       primaryStack.push(val);

       if(minStack.isEmpty()) {
            minStack.push(val);

       } else {
            minStack.push(Math.min(val, minStack.peek()));
       }
    }
    
    // remove elements from both stacks
    public void pop() {
        primaryStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return primaryStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
