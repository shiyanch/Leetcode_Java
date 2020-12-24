package SumOfNodesWithEvenValuedGrandparent;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 *
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 */
public class SumOfNodesWithEvenValuedGrandparent {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                sum += root.left.left == null ? 0 : root.left.left.val;
                sum += root.left.right == null ? 0 : root.left.right.val;
            }

            if (root.right != null) {
                sum += root.right.left == null ? 0 : root.right.left.val;
                sum += root.right.right == null ? 0 : root.right.right.val;
            }
        }

        return sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right) + sum;
    }

}
