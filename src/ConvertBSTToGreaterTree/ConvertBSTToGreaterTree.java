package ConvertBSTToGreaterTree;

import DiameterOfBinaryTree.DiameterOfBinaryTree;

/**
 * 538. Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Input: The root of a Binary Search Tree like this:
 *    5
 *  /   \
 * 2     13
 *
 * Output: The root of a Greater Tree like this:
 *    18
 *   /   \
 * 20     13
 */
public class ConvertBSTToGreaterTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
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
