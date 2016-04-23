package SymmetricTree;

import java.util.*;

/**
 * 101. Symmetric Tree
 * Given a binary tree
 * check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following is not:
 *   1
 *  / \
 * 2   2
 * \   \
 * 3   3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * 错误解法:先进行inorder,再进行回文判断 -> 反例:[1,2,3,3,null,2,null]
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricHelper(root.left, root.right);
    }

    // recursive
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;

        if(left.val != right.val)
            return false;

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    // bfs
    public boolean isSysmmetric2(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);

        while(queue.size() > 1){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null)
                continue;
            if(left == null ^ right == null)
                return false;

            if(left.val != right.val)
                return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    // dfs
    public boolean isSysmmetric3(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;

        if(!process(root.left, root.right, stack))
            return false;

        while(!stack.isEmpty()) {
            if(stack.size() % 2 != 0)
                return false;

            right = stack.pop();
            left = stack.pop();

            if(right.val != left.val)
                return false;
            if(!process(left.left, right.right, stack))
                return false;
            if(!process(left.right, right.left, stack))
                return false;
        }
        return true;
    }

    private boolean process(TreeNode left, TreeNode right, Stack<TreeNode> stack) {
        if(left != null) {
            if(right == null)
                return false;

            stack.push(left);
            stack.push(right);
        }
        else if(right != null)
            return false;

        return true;
    }
}
