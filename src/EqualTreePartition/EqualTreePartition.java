package EqualTreePartition;

import java.util.HashMap;
import java.util.Map;

/**
 * 663. Equal Tree Partition
 *
 * Given a binary tree with n nodes,
 * your task is to check if it's possible to partition the tree to two trees
 * which have the equal sum of values after removing exactly one edge on the original tree.
 */
public class EqualTreePartition {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> dict = new HashMap<>();
        int sum = getTotalSum(root, dict);
        if (sum == 0) {
            return dict.get(0) > 1;
        }
        return sum %2 == 0 && dict.containsKey(sum/2);
    }

    private int getTotalSum(TreeNode root, Map<Integer, Integer> dict) {
        if (root == null) {
            return 0;
        }

        int sum = getTotalSum(root.left, dict) + root.val + getTotalSum(root.right, dict);
        dict.put(sum, dict.getOrDefault(sum, 0)+1);
        return sum;
    }
}
