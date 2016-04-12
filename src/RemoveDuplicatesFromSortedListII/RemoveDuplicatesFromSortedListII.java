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

        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode pre = helper;
        ListNode current = helper.next;

        boolean hasDuplicated = false;

        while(current.next != null) {
            if(current.val == current.next.val) {
                // contains duplicates, set the tag and move on
                hasDuplicated = true;
            }
            else {
                if(hasDuplicated)
                    // drop nodes from pre.next to current
                    // so link pre node to current.next node
                    pre.next = current.next;
                else
                    // reserver current node, move pre to current
                    pre = current;

                // handled duplicates, clear the tag
                hasDuplicated = false;
            }
            current = current.next;

        }

        // if duplicates unhandled
        // drop nodes from pre.next to current
        if(hasDuplicated)
            pre.next = current.next;

        return helper.next;
    }
}
