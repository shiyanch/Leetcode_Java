package BalancedBinaryTree;

import java.util.*;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is
 * defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.


 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isBanalced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1)
            return -1;

        return 1+Math.max(left, right);
    }
}
