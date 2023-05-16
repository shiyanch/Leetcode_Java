package DesignCircularQueue;

/**
 * 622. Design Circular Queue
 *
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the
 * operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to
 * the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal
 * queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 *
 * Implement the MyCircularQueue class:
 *
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 * You must solve the problem without using the built-in queue data structure in your programming language.
 */
public class DesignCircularQueue {
    ListNode startNode;
    ListNode frontNode;
    ListNode rearNode;

    public DesignCircularQueue(int k) {
        ListNode firstNode = new ListNode();
        ListNode currNode = firstNode;
        while (k-- > 1) {
            currNode.next = new ListNode();
            currNode = currNode.next;
        }
        currNode.next = firstNode;
        startNode = firstNode;
    }

    public boolean enQueue(int value) {
        if (rearNode == null) {
            startNode.value = value;
            rearNode = startNode;
            frontNode = startNode;
            return true;
        }

        if (rearNode.next == frontNode) {
            // full
            return false;
        }

        rearNode.next.value = value;
        rearNode = rearNode.next;
        return true;
    }

    public boolean deQueue() {
        if (frontNode == null) {
            // empty
            return false;
        }

        if (frontNode == rearNode) {
            // last node
            frontNode = null;
            rearNode = null;
            return true;
        }

        frontNode = frontNode.next;
        return true;
    }

    public int Front() {
        return frontNode == null ? -1 : frontNode.value;

    }

    public int Rear() {
        return rearNode == null ? -1 : rearNode.value;
    }

    public boolean isEmpty() {
        return frontNode == null;
    }

    public boolean isFull() {
        return rearNode != null && rearNode.next == frontNode;
    }

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {}

        public ListNode(int value) {
            this.value = value;
        }
    }
}
