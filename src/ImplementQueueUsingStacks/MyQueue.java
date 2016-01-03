package ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 * 1.push(x) -- Push element x to the back of queue.
 * 2.pop() -- Removes the element from in front of queue.
 * 3.peek() -- Get the front element.
 * 4.empty() -- Return whether the queue is empty.
 *
 * Notes:
 * 1. You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * 2. Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * 3.You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

public class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }

    public void pop() {
        if(!s2.isEmpty()) s2.pop();
        else {
            while(!s1.isEmpty())
                s2.push(s1.pop());
            s2.pop();
        }
    }

    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();
        else {
            while(!s1.isEmpty())
                s2.push(s1.pop());
            return s2.peek();
        }
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
