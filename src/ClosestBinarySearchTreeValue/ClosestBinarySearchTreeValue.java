package ClosestBinarySearchTreeValue;

/**
 * 270. Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ClosestBinarySearchTreeValue {
    private double min = Double.MAX_VALUE;

    public int closestValue_recursive(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue_recursive(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }

    public int closestValue_iterative(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            root = root.val <= target ? root.right : root.left;
        }
        return closest;
    }


    // Accepted, but very slow
    public int closestValue_slow(TreeNode root, double target) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left == null) {
            int subTree = closestValue_slow(root.right, target);
            return Math.abs(root.val - target) < Math.abs(subTree - target) ? root.val : subTree;
        }

        if (root.right == null) {
            int subTree = closestValue_slow(root.left, target);
            return Math.abs(root.val - target) < Math.abs(subTree - target) ? root.val : subTree;
        }

        int leftSubTree = closestValue_slow(root.left, target);
        int rightSubTree = closestValue_slow(root.right, target);
        int subTree = Math.abs(leftSubTree - target) < Math.abs(rightSubTree - target) ? leftSubTree : rightSubTree;
        return Math.abs(root.val - target) < Math.abs(subTree - target) ? root.val : subTree;
    }
}
