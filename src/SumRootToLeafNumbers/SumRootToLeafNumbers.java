package SumRootToLeafNumbers;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only,
 * each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *   1
 *  / \
 * 2   3
 *
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        recursive_count(root, 0);
        return sum;
    }

    private void recursive_count(TreeNode root, int tempSum) {
        if(root.left != null)
            recursive_count(root.left, tempSum*10+root.val);

        if(root.right != null)
            recursive_count(root.right, tempSum*10+root.val);

        if(root.left == null && root.right == null)
            sum += (tempSum*10 + root.val);
    }
}
