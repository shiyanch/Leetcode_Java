package LinkedListRandomNode;

/**
 * 382. Linked List Random Node
 *
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * http://blog.jobbole.com/42550/
 */
public class LinkedListRandomNode {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode temp = head;
        int value = temp.val;

        for(int i=1;temp.next!=null;i++) {
            temp = temp.next;
            if(randInt(0,i) == i)
                value = temp.val;
        }
        return value;
    }

    private int randInt(int min, int max) {
        return min+(int)(Math.random() * (max-min+1));
    }
}
