package RecoverBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 99. Recover Binary Search Tree
 *
 * wo elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if(root == null)
            return;

        traverse(root.left);

        if(first == null && prev.val >= root.val)
            first = prev;

        if(first != null && prev.val >= root.val)
            second = root;

        prev = root;

        traverse(root.right);
    }



    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.right = node5;

        recoverTree(node4);
    }
}
