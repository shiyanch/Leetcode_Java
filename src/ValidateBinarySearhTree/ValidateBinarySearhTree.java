package ValidateBinarySearhTree;

import java.util.*;

/**
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree,
 * determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearhTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // inorder-traversal
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;

        TreeNode p = root;

        // to preserve minimum node of left-subtree
        TreeNode pre = null;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                TreeNode node = stack.pop();
                if(pre != null && node.val <= pre.val)
                    return false;

                pre = node;
                p = node.right;
            }
        }

        return true;
    }

    // recursive
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if(root == null)
            return true;
        if(root.val >= maxVal || root.val <= minVal)
            return false;

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}
