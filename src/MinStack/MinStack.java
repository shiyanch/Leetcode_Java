package MinStack;

import java.util.Stack;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 1.push(x) -- Push element x onto stack.
 * 2.pop() -- Removes the element on top of the stack.
 * 3.top() -- Get the top element.
 * 4.getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() >= x) // = means multiple minimum element
            min.push(x);
    }

    public void pop() {
        if(stack.peek().equals(min.peek())) {
            stack.pop();
            min.pop();
        }
        else
            stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
