package LongestUnivaluePath;

/**
 * 687. Longest Univalue Path
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class LongestUnivaluePath {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longest = 1;
        helper(root);
        return longest-1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int count = 1;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left != 0 && root.val == root.left.val) {
            count += left;
        }

        if (right != 0 && root.val == root.right.val) {
            longest = Math.max(longest, count + right); // In case of the path go through root and its two children
            count = Math.max(count, 1+right);
        }
        longest = Math.max(longest, count); // Important to check single-way path
        return count;
    }
}
