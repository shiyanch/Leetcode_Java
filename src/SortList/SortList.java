package SortList;

/**
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = null, walker = head, runner = head;
        while(runner != null && runner.next != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }

        prev.next = null;

        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(walker);

        return mergeList(firstHalf, secondHalf);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0), current = newHead;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if(l1 != null) {
            current.next = l1;
        }

        if(l2 != null) {
            current.next = l2;
        }

        return newHead.next;
    }
}
