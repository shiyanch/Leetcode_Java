package DeepestLeavesSum;

/**
 * 1302. Deepest Leaves Sum
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {
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

    public int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSum(root, 0)[1];
    }

    /**
     * @return a two elements array, the first element is the maximum depth in this sub tree,
     * the second element is the deepest leaves sum of this subtree.
     */
    private int[] deepestLeavesSum(TreeNode node, int currDepth) {
        if (node == null) {
            return new int[2];
        }

        // Current node is a leaf.
        if (node.left == null && node.right == null) {
            return new int[] {currDepth, node.val};
        }

        int[] leftChildResult = deepestLeavesSum(node.left, currDepth + 1);
        int[] rightChildResult = deepestLeavesSum(node.right, currDepth + 1);

        // Sum up the deepest leaves.
        if (leftChildResult[0] == rightChildResult[0]) {
            return new int[] {leftChildResult[0], leftChildResult[1] + rightChildResult[1]};
        }

        // Pick the deeper leaves.
        return leftChildResult[0] > rightChildResult[0] ? leftChildResult : rightChildResult;
    }
}
