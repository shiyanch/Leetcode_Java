package RemoveNthNodeFromEndOfList;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end,
 * the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null)
            return head;

        ListNode tag = head;

        while(--n > 0) {
            tag = tag.next;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode lastNode = newHead;

        while(tag.next != null) {
            lastNode = lastNode.next;
            tag = tag.next;
        }

        lastNode.next = lastNode.next.next;

        return newHead.next;
    }
}
