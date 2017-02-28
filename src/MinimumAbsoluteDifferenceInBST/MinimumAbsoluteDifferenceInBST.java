package MinimumAbsoluteDifferenceInBST;

import java.util.Stack;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 */

public class MinimumAbsoluteDifferenceInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode last = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                TreeNode node = stack.pop();
                if (node != last) {
                    min = Math.min(min, Math.abs(node.val-last.val));
                    last = node;
                }
                p = node.right;
            }
        }
        return min;
    }
}
