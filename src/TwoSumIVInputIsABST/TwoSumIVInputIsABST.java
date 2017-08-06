package TwoSumIVInputIsABST;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 *
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST
 * such that their sum is equal to the given target.
 */
public class TwoSumIVInputIsABST {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k-root.val)) {
            return true;
        }

        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
