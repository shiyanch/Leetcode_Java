package LargestBSTSubtree;

/**
 * 333. Largest BST Subtree
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        int res = verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return (res >= 0) ? res : Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int verify(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val <= min || root.val >= max) {
            return -1;
        }
        int left = verify(root.left, min, root.val);
        int right = verify(root.right, root.val, max);
        return (left == -1 || right == -1) ? -1 : 1 + left + right;
    }
}