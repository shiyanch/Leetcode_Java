package MaximumWidthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.

 The width of one level is defined as the length between the end-nodes
 (the leftmost and right most non-null nodes in the level,
 where the null nodes between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        int max = 0;
        queue.offer(root);
        index.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0;
            int right = 0;
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                int currIndex = index.poll();
                if (i == 0) {
                    left = currIndex;
                }
                if (i == size-1) {
                    right = currIndex;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                    index.offer(2*currIndex);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    index.offer(2*currIndex+1);
                }
            }
            max = Math.max(max, right-left+1);
        }

        return max;

    }
}
