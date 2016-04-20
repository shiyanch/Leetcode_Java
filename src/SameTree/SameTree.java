package SameTree;

import java.util.Stack;

/**
 * 100. Same Tree
 * Given two binary trees
 * write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if((p != null && q == null )||(p == null && q != null))
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        if(p!=null) stackP.push(p);
        if(q!=null) stackQ.push(q);

        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();

            if(nodeP.val != nodeQ.val)
                return false;

            if(nodeP.right != null) stackP.push(nodeP.right);
            if(nodeQ.right != null) stackQ.push(nodeQ.right);
            if(stackP.size() != stackQ.size()) return false;

            if(nodeP.left != null) stackP.push(nodeP.left);
            if(nodeQ.left != null) stackQ.push(nodeQ.left);
            if(stackP.size() != stackQ.size()) return false;
        }

        return (stackP.size() == stackQ.size());
    }
}
