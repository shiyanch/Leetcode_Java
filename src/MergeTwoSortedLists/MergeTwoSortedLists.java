package MergeTwoSortedLists;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l2.next, l1);
        }

        return mergeHead;
    }
}
