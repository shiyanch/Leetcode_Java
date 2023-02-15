package MinimumDistanceBetweenBSTNodes;

import Utility.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes
 *
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 */
public class MinimumDistanceBetweenBSTNodes {

    private int mini = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        getMinAndMaxInSubTree(root);
        return mini;
    }

    private int[] getMinAndMaxInSubTree(TreeNode node) {
        int[] minAndMax = new int[] {node.val, node.val};

        if (node.left == null && node.right == null) {
            return minAndMax;
        }

        if (node.left != null) {
            int[] left = getMinAndMaxInSubTree(node.left);
            mini = Math.min(mini, Math.abs(left[1] - node.val));
            minAndMax[0] = left[0];
        }

        if (node.right != null) {
            int[] right = getMinAndMaxInSubTree(node.right);
            mini = Math.min(mini, Math.abs(right[0] - node.val));
            minAndMax[1] = right[1];
        }

        return minAndMax;
    }
}
