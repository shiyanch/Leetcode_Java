package BinaryTreeUpsideDown;

/**
 * 156. Binary Tree Upside Down
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree
 * where the original right nodes turned into left leaf nodes.
 *
 * Return the new root.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return new TreeNode(root.val);
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode node = newRoot;
        while(node.right != null) {
            node = node.right;
        }
        node.left = upsideDownBinaryTree(root.right);
        node.right = new TreeNode(root.val);
        return newRoot;
    }
}
