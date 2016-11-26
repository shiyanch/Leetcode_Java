package PlusOneLinkedList;

import StringToInteger.StringToInteger;

/**
 * 369. Plus One Linked List
 *
 * Given a non-negative number represented as a singly linked list of digits,
 * plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class PlusOneLinkedList {

    // find last node that val is not 9
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy;
        ListNode node = head;

        while (node != null) {
            lastNotNine = node.val != 9?node:lastNotNine;
            node = node.next;
        }
        lastNotNine.val++;
        node = lastNotNine.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        return dummy.val == 1?dummy:dummy.next;
    }

    // reverse twice
    public ListNode plusOne2(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        while(curr != null) {
            ListNode node = curr;
            curr = curr.next;
            node.next = newHead.next;
            newHead.next = node;
        }

        curr = newHead.next;
        boolean carry = true;

        head = new ListNode(0);
        while (curr != null) {
            curr.val += (carry)?1:0;
            carry = curr.val >= 10;
            curr.val = curr.val % 10;

            ListNode node = curr;
            curr = curr.next;
            node.next = head.next;
            head.next = node;
        }

        if (carry) {
            ListNode newNode = new ListNode(1);
            newNode.next = head.next;
            head.next = newNode;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        System.out.println(new PlusOneLinkedList().plusOne(head).val);
    }
}
