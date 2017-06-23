package BinaryTreeLongestConsecutiveSequenceII;

import BinaryTreeLevelOrderTraversalII.BinaryTreeLevelOrderTraversalII;

/**
 * 549. Binary Tree Longest Consecutive Sequence II
 *
 * Given a binary tree,
 * you need to find the length of Longest Consecutive Path in Binary Tree.
 * Especially, this path can be either increasing or decreasing.
 * For example, [1,2,3,4] and [4,3,2,1] are both considered valid,
 * but the path [1,2,4,3] is not valid.
 *
 * On the other hand, the path can be in the child-Parent-child order,
 * where not necessarily be parent-child order.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    // (x, y)
    // x: down
    // y: up
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int leftLen = 1;
        int rightLen = 1;
        int[] flag = {1,1};
        if (root.left != null) {
            if (root.left.val == root.val-1) {
                leftLen += left[0];
                flag[0] = leftLen;
            }
            if (root.left.val == root.val+1) {
                leftLen += left[1];
                flag[1] = leftLen;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val-1) {
                rightLen += right[0];
                flag[0] = Math.max(flag[0], rightLen);
                if (root.left != null && root.left.val == root.val+1) {
                    max = Math.max(max, leftLen + rightLen - 1);
                }
            }
            if (root.right.val == root.val+1) {
                rightLen += right[1];
                flag[1] = Math.max(flag[1], rightLen);
                if (root.left != null && root.left.val == root.val-1) {
                    max = Math.max(max, leftLen + rightLen - 1);
                }
            }
        }
        max = Math.max(max, Math.max(leftLen, rightLen));
        return flag;
    }
}
