package DiameterOfBinaryTree;

/**
 * 543. Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.longest = 0;
        recursiveDiameter(root);
        return this.longest;

    }

    private int recursiveDiameter(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = recursiveDiameter(root.left);
        int right = recursiveDiameter(root.right);
        longest = Math.max(longest, left + right + 2);

        return Math.max(left, right) + 1;
    }
}
