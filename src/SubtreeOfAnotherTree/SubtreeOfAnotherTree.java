package SubtreeOfAnotherTree;

/**
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 *
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.val == t.val && sameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }

        if (s.val != t.val) {
            return false;
        }

        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}
