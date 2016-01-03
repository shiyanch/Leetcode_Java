package ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 * 1.push(x) -- Push element x onto stack.
 * 2.pop() -- Removes the element on top of the stack.
 * 3.top() -- Get the top element.
 * 4.empty() -- Return whether the stack is empty.
 *
 * Notes:
 * 1.You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * 2.Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * 3.You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

public class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int x){
        queue1.offer(x);
    }

    public void pop() {
        while(queue1.size()>1)
            queue2.offer(queue1.poll());
        queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int top() {
        while(queue1.size()>1)
            queue2.offer(queue1.poll());
        int res = queue1.poll();
        queue2.offer(res);

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return res;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}