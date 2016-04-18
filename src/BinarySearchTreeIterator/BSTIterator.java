package BinarySearchTreeIterator;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory
 * where h is the height of the tree.
 */
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node.right;

        // deal with right subtree's left subtree
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        return node.val;
    }

}
