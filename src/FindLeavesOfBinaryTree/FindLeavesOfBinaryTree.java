package FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Returns [4, 5, 3], [2], [1].
 * */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }

        int height =
                (root.left == null && root.right == null)?
                        0:
                        Math.max(findLeaves(root.left, result), findLeaves(root.right, result));

        while (result.size() <= height) {
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        return height + 1;
    }
}
