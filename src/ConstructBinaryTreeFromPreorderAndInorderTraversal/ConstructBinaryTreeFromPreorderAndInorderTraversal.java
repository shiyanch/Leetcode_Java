package ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,preorder.length-1,preorder,inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 || inEnd < inStart)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++)
            if(inorder[i] == root.val)
                inIndex = i;

        root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);

        return root;
    }
}
