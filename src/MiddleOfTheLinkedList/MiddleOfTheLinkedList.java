package MiddleOfTheLinkedList;

import Utility.ListNode;

/**
 * 876. Middle of the Linked List
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null | head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next == null) {
                return first;
            }
            second = second.next;
            if (second.next == null) {
                return first;
            }
        }

        return first;
    }
}
