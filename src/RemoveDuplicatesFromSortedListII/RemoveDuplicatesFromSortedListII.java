package RemoveDuplicatesFromSortedListII;

/**
 * 82. Remove Duplicates from Sorted List II
 * Given a sorted linked list
 * delete all nodes that have duplicate numbers
 * leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode last = dummy;
        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            if(last.next != cur) {
                last.next = cur.next;
            }
            else {
                last = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
