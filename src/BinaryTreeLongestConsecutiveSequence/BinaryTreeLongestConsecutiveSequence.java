package BinaryTreeLongestConsecutiveSequence;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 *
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeLongestConsecutiveSequence {
    private int count = 0;

    public int longestConsecutive(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            count = Math.max(count, 1);
            return 1;
        }
        // 保证每个子节点都进行了计算
        int left = helper(root.left);
        int right = helper(root.right);

        int tmp = 1;
        if (root.left != null && root.left.val == root.val+1) {
            tmp = 1 + left;
        }
        if (root.right != null && root.right.val == root.val+1) {
            tmp = Math.max(tmp, 1 + right);
        }
        count = Math.max(count, tmp);
        return tmp;
    }
}
