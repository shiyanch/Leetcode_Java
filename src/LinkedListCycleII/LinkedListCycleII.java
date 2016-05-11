package LinkedListCycleII;

/**
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * https://leetcode.com/discuss/9908/o-n-solution-by-using-two-pointers-without-change-anything
 */
public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode walker = head;
        ListNode runner = head;

        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if(walker == runner) {
                while ( head != walker) {
                    head = head.next;
                    walker = walker.next;
                }
                return head;
            }
        }

        return null;
    }
}
