package ConstructBinaryTreeFromInorderAndPreorderTraversal;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rebuild(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }

    private TreeNode rebuild(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {

        if(postEnd < 0 || inEnd < inStart)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++)
            if(inorder[i] == root.val)
                inIndex = i;

        root.right = rebuild(inorder, postorder, inIndex+1, inEnd, postEnd-1);
        root.left = rebuild(inorder, postorder, inStart, inIndex-1, postEnd - inEnd + inIndex -1);

        return root;
    }
}
