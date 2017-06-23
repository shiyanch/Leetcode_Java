package BoundaryOfBinaryTree;

import java.util.*;

/**
 * 545. Boundary of Binary Tree
 *
 * Given a binary tree,
 * return the values of its boundary in anti-clockwise direction starting from root.
 *
 * Boundary includes left boundary, leaves,
 * and right boundary in order without duplicate nodes.
 *
 * Left boundary is defined as the path from root to the left-most node.
 * Right boundary is defined as the path from root to the right-most node.
 * If the root doesn't have left subtree or right subtree,
 * then the root itself is left boundary or right boundary.
 *
 * Note this definition only applies to the input binary tree,
 * and not applies to any subtrees.
 * The left-most node is defined as a leaf node you could reach
 * when you always firstly travel to the left subtree if exists.
 *
 * If not, travel to the right subtree.
 * Repeat until you reach a leaf node.
 * The right-most node is also defined by the same way with left and right exchanged.
 */
public class BoundaryOfBinaryTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        left(root.left, list);
        leaf(root.left, list);
        leaf(root.right, list);
        right(root.right, list);
        return list;
    }

    private void left(TreeNode root, List<Integer> list) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        list.add(root.val);
        if (root.left == null) {
            left(root.right, list);
        } else {
            left(root.left, list);
        }
    }

    private void right(TreeNode root, List<Integer> list) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            right(root.left, list);
        } else {
            right(root.right, list);
        }
        list.add(root.val);
    }

    private void leaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        leaf(root.left, list);
        leaf(root.right, list);
    }
}
