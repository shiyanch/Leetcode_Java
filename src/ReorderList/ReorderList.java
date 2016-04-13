package ReorderList;

/**
 * 143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Testcases:
 * [1,2,3,4,5,4,3,2,1] -> [1,1,2,2,3,3,4,4,5]
 * [1,2,3,4,4,3,2,1] -> [1,1,2,2,3,3,4,4]
 * [1,2] -> [1,2]
 * [1] -> [1]
 * [] -> []
 */
public class ReorderList {
    private ListNode head;

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode secondHalf = split(head);
        secondHalf = reverse(secondHalf);
        merge(head, secondHalf);
    }

    private ListNode split(ListNode head) {
        ListNode tail = null;
        ListNode walker = head, runner = head;

        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        tail = walker;
        walker = walker.next;
        tail.next = null;
        return walker;

    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode helper = new ListNode(0);

        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = helper.next;
            helper.next = cur;
        }

        return helper.next;
    }

    private void merge(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(l2 != null) {
            cur2 = l2;
            l2  = l2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = cur2.next;
        }
    }

    private void add(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    public void test() {
//        add(8);
//        add(7);
//        add(6);
//        add(5);
//        add(4);
        add(3);
        add(2);
        add(1);

        reorderList(head);
//        ListNode hehe = split(head);
        ListNode hehe = this.head;

//        hehe = reverse(hehe);
        while(hehe!=null) {
            System.out.print(hehe.val+" ");
            hehe = hehe.next;
        }
    }
}
