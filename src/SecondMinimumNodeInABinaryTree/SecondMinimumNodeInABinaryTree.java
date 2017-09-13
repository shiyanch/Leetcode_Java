package SecondMinimumNodeInABinaryTree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 671. Second Minimum Node In a Binary Tree
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node.
 *
 * If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree,
 * you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInABinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        Set<Integer> set = new TreeSet<>();
        dfs(root, set);
        if (set.size() < 2) {
            return -1;
        }

        Iterator<Integer> iterator = set.iterator();
        iterator.next();
        return iterator.next();

    }

    private void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }

        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}
