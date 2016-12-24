package AddTwoNumbersII;

import java.util.List;
import java.util.Stack;

/**
 * 445. Add Two Numbers II
 *
 * You are given two linked lists representing two non-negative numbers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int cur = (s1.isEmpty()?0:s1.pop()) + (s2.isEmpty()?0:s2.pop()) + carry;
            carry = cur/10;
            if (cur > 9) {
                cur %= 10;
            }

            ListNode node = new ListNode(cur);
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }
}
