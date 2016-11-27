package BinaryTreeVerticalOrderTraversal;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values.
 * (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Map<TreeNode, Integer> columnMap = new HashMap<>();
        Map<Integer, List<Integer>> vertical = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        columnMap.put(root, 0);
        int col;
        while (!queue.isEmpty()) {
            root = queue.poll();
            col = columnMap.get(root);
            if (!vertical.containsKey(col)) {
                vertical.put(col, new ArrayList<>());
            }
            vertical.get(col).add(root.val);
            if (root.left != null) {
                columnMap.put(root.left, col - 1);
                queue.offer(root.left);
            }
            if (root.right != null) {
                columnMap.put(root.right, col + 1);
                queue.offer(root.right);
            }
        }
        return new ArrayList<>(vertical.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(0);
        root.left = a;
        root.right = b;
        List<List<Integer>> lists = new BinaryTreeVerticalOrderTraversal().verticalOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
}
