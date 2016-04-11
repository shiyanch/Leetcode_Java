package ReverseLinkedList;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newList = null;

        while(head != null) {
            ListNode current = head;
            head = current.next;
            current.next = newList;
            newList = current;
        }

        return newList;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseListRecursive(next, head);
    }
}
