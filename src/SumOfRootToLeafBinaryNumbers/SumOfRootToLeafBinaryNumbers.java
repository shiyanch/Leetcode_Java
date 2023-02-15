package SumOfRootToLeafBinaryNumbers;

import Utility.TreeNode;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 *
 * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a
 * binary number starting with the most significant bit.
 *
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum
 * of these numbers.
 *
 * The test cases are generated so that the answer fits in a 32-bits integer.
 */
public class SumOfRootToLeafBinaryNumbers {
    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        addLeafBinaryIntoSum(root, 0);
        return sum;
    }

    private void addLeafBinaryIntoSum(TreeNode node, int currentBinary) {
        currentBinary += node.val;
        if (node.left == null && node.right == null) {
            sum += currentBinary;
            return;
        }

        currentBinary *= 2;
        if (node.left != null) {
            addLeafBinaryIntoSum(node.left, currentBinary);
        }

        if (node.right != null) {
            addLeafBinaryIntoSum(node.right, currentBinary);
        }
    }
}
