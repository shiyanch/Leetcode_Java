package ClosestBinarySearchTreeValueII;

import java.util.LinkedList;
import java.util.List;

/**
 * 272. Closest Binary Search Tree Value II
 *
 * Given a non-empty binary search tree and a target value,
 * find k values in the BST that are closest to the target.
 *
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST
 * that are closest to the target.
 *
 * Follow up:
 * Assume that the BST is balanced,
 * could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinarySearchTreeValueII {
    static class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int x) {
            this.val = x;
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, list, target, k);
        return list;
    }

    private boolean helper(TreeNode root, LinkedList<Integer> list, double target, int k) {
        if (root == null) {
            return false;
        }

        if (helper(root.left, list, target, k)) {
            return true;
        }

        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return true;
            } else {
                list.removeFirst();
            }
        }
        list.add(root.val);
        return helper(root.right, list, target, k);
    }
}
