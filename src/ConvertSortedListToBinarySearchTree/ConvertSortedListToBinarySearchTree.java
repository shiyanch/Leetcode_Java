package ConvertSortedListToBinarySearchTree;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order
 * convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode walker = head;
        ListNode runner = head;

        if(head == tail)
            return null;

        while(runner != tail && runner.next != tail) {
            runner = runner.next.next;
            walker = walker.next;
        }

        TreeNode treeHead = new TreeNode(walker.val);
        treeHead.left = toBST(head, walker);
        treeHead.right = toBST(walker.next, tail);
        return treeHead;
    }

}
