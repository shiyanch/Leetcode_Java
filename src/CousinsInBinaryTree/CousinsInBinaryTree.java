package CousinsInBinaryTree;

import Utility.TreeNode;

/**
 * 993. Cousins in Binary Tree
 *
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
 * return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 */
public class CousinsInBinaryTree {
    private TreeNode parentOfX;
    private TreeNode parentOfY;
    private int depthOfX;
    private int depthOfY;
    public boolean isCousins(TreeNode root, int x, int y) {
        findTargetNodesAndRecordDepth(root, null, x, y, 0);
        return depthOfX == depthOfY && parentOfY != parentOfX;
    }

    private void findTargetNodesAndRecordDepth(TreeNode node, TreeNode parent, int x, int y, int currentDepth) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            parentOfX = parent;
            depthOfX = currentDepth;
        }

        if (node.val == y) {
            parentOfY = parent;
            depthOfY = currentDepth;
        }

        if (parentOfX != null && parentOfY != null) {
            return;
        }

        findTargetNodesAndRecordDepth(node.left, node, x, y, currentDepth + 1);
        findTargetNodesAndRecordDepth(node.right, node, x, y, currentDepth + 1);
    }
}
