package CountUnivalueSubtrees;

/**
 * 250. Count Univalue Subtrees
 *
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *     5
 *    / \
 *   1   5
 *  / \   \
 * 5   5   5
 *
 * return 4.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class CountUnivalueSubtrees {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (!left || !right) {
            return false;
        }

        if ((root.left != null && root.val != root.left.val) || (root.right != null && root.val != root.right.val)){
            return false;
        }

        count ++;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(root));
    }
}
