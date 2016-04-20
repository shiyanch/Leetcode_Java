package InvertBinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */

public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return root;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if(root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null)
                queue.offer(node.left);

            if(node.right != null)
                queue.offer(node.right);
        }
        return root;
    }
}
