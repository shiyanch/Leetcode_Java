package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Testcase:
 * [1,2,3,4,5,6,7,null,null,8,null,null,9] -> [4,2,8,5,1,6,9,3,7,1]
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // this approach will change the structure of original tree
    // thus not recommend
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        stack.push(root);
        TreeNode node;

        while(!stack.empty()) {
            node = stack.peek();

            if(node.left != null) {
                stack.push(node.left);
                continue;
            }

            list.add(stack.pop().val);

            if(!stack.empty())
                stack.peek().left = null;

            if(node.right != null)
                stack.push(node.right);
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        TreeNode cur = root;
        while( cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
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

        ArrayList<Integer> list = (ArrayList) inorderTraversal(a);
    }
}
