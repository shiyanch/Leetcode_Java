package AddTwoNumbers;

/**
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null)?0:l2.val) + ((l1 == null)?0:l1.val) + carry;

            cur.val = sum % 10;
            carry = sum/10;

            prev.next = cur;
            prev = cur;

            l1 = (l1 == null)?l1:l1.next;
            l2 = (l2 == null)?l2:l2.next;
        }

        return head.next;
    }
}
