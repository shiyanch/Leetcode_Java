package IntersectionOfTwoLinkedLists;

import java.util.HashSet;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 * 1. If the two linked lists have no intersection at all, return null.
 * 2. The linked lists must retain their original structure after the function returns.
 * 3. You may assume there are no cycles anywhere in the entire linked structure.
 * 4. Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int lenA = length(headA);
        int lenB = length(headB);

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int length(ListNode head) {
        int count=0;
        while(head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        HashSet<ListNode> hashSet = new HashSet<>();

        while(headB != null) {
            hashSet.add(headB);
            headB = headB.next;
        }

        while(headA != null) {
            if(hashSet.contains(headA))
                return headA;
            else
                headA = headA.next;
        }

        return null;
    }
}
