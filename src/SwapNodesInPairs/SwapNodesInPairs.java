package SwapNodesInPairs;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list
 * swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4,
 * you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * Testcases:
 * [1]          -> [1]
 * [1,2,3,4,5]  -> [2,1,4,3,5]
 * [1,2,3,4]    -> [2,1,4,3]
 * []           -> []
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        int count = 1;
        ListNode current = head;

        while(current != null && current.next != null) {
            if(count % 2 == 0) {
                count++;
            }
            else {
                int temp = current.val;
                current.val = current.next.val;
                current.next.val = temp;
                count++;
            }
            current = current.next;
        }

        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        int count = 1;
        ListNode current = newHead;

        while(current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }

        return newHead.next;
    }

    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;

        while (odd != null && even != null) {
            int temp = odd.val;
            odd.val = even.val;
            even.val = temp;

            if(odd.next == null || even.next == null)
                break;
            else {
                odd = odd.next.next;
                even = even.next.next;
            }
        }
        return head;
    }

    public ListNode swapPairs4(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode node = head.next;
        head.next = swapPairs4(head.next.next);
        node.next = head;

        return node;
    }


}
