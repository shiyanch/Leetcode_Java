package BinaryTreeMaximumPathSum;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 *
 * The path must contain at least one node and does not need to go through the root.
 * For example:
 * Given the below binary tree,
 *   1
 *  / \
 * 2   3
 * Return 6.
 */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeMaximumPathSum {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
