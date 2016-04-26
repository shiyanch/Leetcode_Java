package MinimumDepthOfBinaryTree;

/**
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree
 * find its minimum depth.
 *
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 *
 */
public class MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0)
            return 1+left+right;
        else
            return 1+Math.min(left, right);
    }
}
