package PartitionList;

/**
 * 86. Partition List
 * Given a linked list and a value x
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    private ListNode head;

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null)
            return head;

        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;

        while(head != null) {
            if(head.val < x) {
                lessTail = lessTail.next = head;
            }
            else {
                greaterTail = greaterTail.next = head;
            }
            head = head.next;
        }

        lessTail.next = greaterHead.next;
        greaterTail.next = null;
        return lessHead.next;

    }


    private void add(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    public void test() {
        add(1);
        add(1);
//        add(2);
//        add(3);
//        add(4);
//        add(1);

        ListNode newNode = partition(head, 2);
        while(newNode!=null) {
            System.out.print(newNode.val+" ");
            newNode = newNode.next;
        }
    }
}
