package OddEvenLinkedList;

/**
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place.
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 */

public class OddEvenLinkedList {
    // for debuging
    private ListNode head;

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // for debuging
    public void add(ListNode node) {
        if(node == null)
            return;
        node.next = head;
        head = node;
    }

    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode evenSet = head.next;
        ListNode even = head.next;
        ListNode odd = head;

        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenSet;
        return head;
    }

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode lastOdd = head;
        ListNode current = head;
        int count = 1;

        while(current != null && current.next != null) {
            if(count %2 == 1) {
                count++;
                current = current.next;
            }
            else {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = lastOdd.next;
                lastOdd.next = temp;

                count++;
                lastOdd = lastOdd.next;
            }
        }

        return head;
    }

    // for debuging
    public void test() {
        add(new ListNode(8));
        add(new ListNode(7));
        add(new ListNode(6));
        add(new ListNode(5));
        add(new ListNode(4));
        add(new ListNode(3));
        add(new ListNode(2));
        add(new ListNode(1));

        ListNode temp = oddEvenList(head);
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
}
