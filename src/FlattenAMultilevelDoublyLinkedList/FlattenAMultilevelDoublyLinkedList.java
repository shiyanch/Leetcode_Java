package FlattenAMultilevelDoublyLinkedList;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 *
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 *
 * Example:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 */
public class FlattenAMultilevelDoublyLinkedList {
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        flattenChildList(head);
        return head;
    }

    /**
     * Flatten the child ilst.
     * @param head of the child list.
     * @return the tail node of the child list.
     */
    private Node flattenChildList(Node head) {
        Node curr = head;
        Node tail = curr;
        while (curr != null) {
            if (curr.child != null) {
                // flatten the child list
                Node tailOfChild = flattenChildList(curr.child);
                tailOfChild.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = tailOfChild;
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = tailOfChild.next;
                tail = tailOfChild;
            } else {
                tail = curr;
                curr = curr.next;
            }
        }
        return tail;
    }
}
