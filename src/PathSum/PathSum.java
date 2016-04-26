package PathSum;

import java.util.*;

/**
 * 112. Path Sum
 * Given a binary tree and a sum
 * determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == sum;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sub = new Stack<>();

        stack.push(root);
        sub.push(root.val);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            int tempVal = sub.pop();

            if(temp.left == null && temp.right == null) {
                if (tempVal == sum)
                    return true;
            }

            if(temp.left != null) {
                stack.push(temp.left);
                sub.push(temp.left.val + tempVal);
            }

            if(temp.right != null) {
                stack.push(temp.right);
                sub.push(temp.right.val + tempVal);
            }
        }

        return false;
    }

    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.left = f;
        e.right = g;
        d.left = h;
        f.right = i;

        if(hasPathSum2(a, 19))
            System.out.println("True");
        else
            System.out.println("False");

    }
}
