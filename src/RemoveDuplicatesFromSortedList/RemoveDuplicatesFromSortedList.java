package RemoveDuplicatesFromSortedList;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
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

        ListNode current = head;

        while(current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
                // current.val may equals to new current.next.val
            }
            else {
                current = current.next;
            }
        }

        return head;
    }
}
