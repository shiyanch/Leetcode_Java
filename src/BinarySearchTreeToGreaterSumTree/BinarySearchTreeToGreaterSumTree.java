package BinarySearchTreeToGreaterSumTree;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * 1038. Binary Search Tree to Greater Sum Tree
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 */
public class BinarySearchTreeToGreaterSumTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }

        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }
}
