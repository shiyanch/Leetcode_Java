package PathSumIII;

/**
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {
    int count = 0;
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if(root != null) {
            check(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }

        return count;
    }

    private void check(TreeNode root, int sum) {
        if(root != null) {
            if(sum == root.val) {
                count++;
            }

            check(root.left, sum-root.val);
            check(root.right, sum-root.val);
        }
    }
}
