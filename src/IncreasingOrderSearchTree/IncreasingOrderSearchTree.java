package IncreasingOrderSearchTree;

import Utility.TreeNode;

/**
 * 897. Increasing Order Search Tree
 *
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
 * the root of the tree, and every node has no left child and only one right child.
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        return getLeftAndRightPointers(root)[0];
    }

    private static TreeNode[] getLeftAndRightPointers(TreeNode node) {
        TreeNode[] pointers = new TreeNode[] {node, node};;

        if (node.left == null && node.right == null) {
            return pointers;
        }

        if (node.left != null) {
            TreeNode[] left = getLeftAndRightPointers(node.left);
            left[1].right = node;
            node.left = null;
            pointers[0] = left[0];
        }

        if (node.right != null) {
            TreeNode[] right = getLeftAndRightPointers(node.right);
            node.right = right[0];
            pointers[1] = right[1];
        }

        return pointers;
    }
}
