package AddOneRowToTree;

import BoundaryOfBinaryTree.BoundaryOfBinaryTree;

/**
 * 623. Add One Row to Tree
 *
 * Given the root of a binary tree, then value v and depth d,
 * you need to add a row of nodes with value v at the given depth d.
 * The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d,
 * for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root.
 *
 * And N's original left subtree should be the left subtree of the new left subtree root,
 * its original right subtree should be the right subtree of the new right subtree root.
 *
 * If depth d is 1 that means there is no depth d-1 at all,
 * then create a tree node with value v as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 */
public class AddOneRowToTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, v, d, 1);
        return root;
    }

    private void addRow(TreeNode root, int v, int d, int depth) {
        if (root == null || depth > d-1) {
            return;
        }
        if (depth != d-1) {
            addRow(root.left, v, d, depth+1);
            addRow(root.right, v, d, depth+1);
        }
        else {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }
    }
}
