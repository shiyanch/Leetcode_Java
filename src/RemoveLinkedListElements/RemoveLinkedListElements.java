package RemoveLinkedListElements;

/**
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    private ListNode head;
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode cur = helper;
        while(cur != null && cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }

        return helper.next;
    }

    private void add(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    public void test() {
        add(6);
        add(3);
        add(4);
        add(2);
        add(1);
        add(6);

        ListNode newNode = removeElements(head, 6);
        while(newNode!=null) {
            System.out.print(newNode.val+" ");
            newNode = newNode.next;
        }
    }
}
