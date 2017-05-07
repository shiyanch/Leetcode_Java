package BinaryTreeTilt;

import BinaryTreeUpsideDown.TreeNode;

/**
 * 563. Binary Tree Tilt
 *
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference
 * between the sum of all left subtree node values
 * and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class BinaryTreeTilt {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;
    public int findTilt(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
