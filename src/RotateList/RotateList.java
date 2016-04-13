package RotateList;

/**
 * 61. Rotate List
 * Given a list, rotate the list to the right by k places
 * where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    private ListNode head;
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        int len = length(head);
        k %= len;
        if(k == 0)
            return head;

        head = reverseList(head);
        ListNode secHead;
        ListNode current = head;

        while(k>1) {
            current = current.next;
            k--;
        }

        secHead = current.next;
        current.next = null;

        head = reverseList(head);

        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = reverseList(secHead);

        return head;
    }

    private int length(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newList = null;

        while(head != null) {
            ListNode current = head;
            head = current.next;
            current.next = newList;
            newList = current;
        }

        return newList;
    }

    private void add(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    public void test() {
        add(8);
        add(7);
        add(6);
        add(5);
        add(4);
        add(3);
        add(2);
        add(1);

        head = rotateRight(head,8);

        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
