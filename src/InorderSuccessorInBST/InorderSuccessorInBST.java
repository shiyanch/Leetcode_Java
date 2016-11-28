package InorderSuccessorInBST;

/**
 * 285. Inorder Successor in BST
 *
 * Given a binary search tree and a node in it,
 * find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);
        return left == null?root:left;
    }
}
