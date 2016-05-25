package PathSumII;

import java.util.*;

/**
 * 113. Path Sum II
 *
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currentRes = new LinkedList<>();

        pathSum(root, sum, currentRes, res);

        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentRes, List<List<Integer>> res) {
        if(root == null)
            return;

        currentRes.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) {
            res.add(new LinkedList<>(currentRes));
            currentRes.remove(currentRes.size()-1);
            return;
        }

        pathSum(root.left, sum-root.val, currentRes, res);
        pathSum(root.right, sum-root.val, currentRes, res);
        currentRes.remove(currentRes.size()-1);

    }

    public void test() {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;

        pathSum(a, 22);

    }
}
