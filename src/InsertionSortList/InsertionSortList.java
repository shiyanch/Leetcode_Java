package InsertionSortList;

/**
 * 147. Insertion Sort List
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    private ListNode head;
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        // difficult to sort the list without extra space.
        // use a new list to store the sorted part.
        if(head == null || head.next == null)
            return head;

        ListNode helper = new ListNode(0);
        ListNode current = head;
        ListNode pre = helper;
        ListNode next = null;

        while(current != null) {
            next = current.next;

            while(pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }

            current.next = pre.next;
            pre.next = current;
            pre = helper;
            current = next;
        }
        return helper.next;
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

        ListNode newNode = insertionSortList(head);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }
}
