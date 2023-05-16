package DesignLinkedList;

/**
 * 707. Design Linked List
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 *
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the
 * linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 *
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 *
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion,
 * the new node will be the first node of the linked list.
 *
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 *
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 *
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 */
public class DesignLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode() {}
    }

    private final ListNode dummy;
    public DesignLinkedList() {
        this.dummy = new ListNode();
    }


    public int get(int index) {
        ListNode curr = dummy.next;

        while (index-- > 0 && curr != null) {
            curr = curr.next;
        }

        if (curr != null) {
            return curr.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
    }

    public void addAtTail(int val) {
        ListNode currNode = dummy;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        ListNode currNode = dummy;
        while (index-- > 0 && currNode != null) {
            currNode = currNode.next;
        }

        if (index > 0 || currNode == null) {
            return;
        }

        if (currNode.next == null) {
            currNode.next = new ListNode(val);
            return;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void deleteAtIndex(int index) {
        ListNode currNode = dummy;
        while (index-- > 0 && currNode != null) {
            currNode = currNode.next;
        }

        if (index > 0 || currNode == null) {
            return;
        }

        if (currNode.next != null) {
            currNode.next = currNode.next.next;
        }
    }

    public void printLinkedList() {
        ListNode currNode = dummy;
        while (currNode.next != null) {
            System.out.print(currNode.next.val + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DesignLinkedList linkedList = new DesignLinkedList();

        linkedList.addAtHead(7);
        linkedList.printLinkedList();

        linkedList.addAtHead(2);
        linkedList.printLinkedList();

        linkedList.addAtHead(1);
        linkedList.printLinkedList();

        linkedList.addAtIndex(3, 0);
        linkedList.printLinkedList();

        linkedList.deleteAtIndex(2);
        linkedList.printLinkedList();

        linkedList.addAtHead(6);
        linkedList.printLinkedList();

        linkedList.addAtTail(4);
        linkedList.printLinkedList();

        linkedList.get(4);
        linkedList.printLinkedList();

        linkedList.addAtHead(4);
        linkedList.printLinkedList();

        linkedList.addAtIndex(5, 0);
        linkedList.printLinkedList();

        linkedList.addAtHead(6);
        linkedList.printLinkedList();
    }
}
