package ReverseLinkedListII;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n.
 * Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 */
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode pre = helper;
        int step = m;
        while(step-- > 1) {
            pre = pre.next;
        }

        ListNode mthNode = pre.next;

        while(n-m>0) {
            ListNode toReverse = mthNode.next;
            mthNode.next = toReverse.next;
            toReverse.next = pre.next;
            pre.next = toReverse;
            mthNode = pre.next;

            n--;
        }

        return helper.next;
    }
}
