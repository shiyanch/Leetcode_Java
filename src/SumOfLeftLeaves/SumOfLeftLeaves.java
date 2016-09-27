package SumOfLeftLeaves;

/**
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 *
 * There are two left leaves in the binary tree,
 * with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root.left, true) + helper(root.right, false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        int sum = 0;
        if(root == null)
            return sum;

        if(isLeft && root.left == null && root.right == null)
            sum += root.val;
        else
            sum += (helper(root.left, true) + helper(root.right, false));

        return sum;
    }


}
