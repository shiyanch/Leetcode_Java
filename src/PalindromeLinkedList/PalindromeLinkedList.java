package PalindromeLinkedList;

/**
 * 234. Palindrome Linked List
 * Given a singly linked list
 * determine if it is a palindrome.
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        if(head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode midNode = findMidNode(head);
        midNode.next = reverse(midNode.next);

        while(midNode.next != null) {
            if(head.val != midNode.next.val)
                return false;
            else {
                head = head.next;
                midNode = midNode.next;
            }
        }
        return true;
    }


    private ListNode findMidNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }

        return walker;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode current = head;
            head = current.next;
            current.next = newHead;
            newHead = current;
        }
        return newHead;
    }
}
