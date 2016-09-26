package HouseRobberIII;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * 337. House Robber III
 *
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/14
 */
public class HouseRobberIII {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robSub(root, map);
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        int val = 0;
        if(root.left != null)
            val += robSub(root.left.left, map)+robSub(root.left.right, map);
        if(root.right != null)
            val += robSub(root.right.left, map)+robSub(root.right.right, map);

        val = Math.max(val+root.val, robSub(root.left, map)+robSub(root.right, map));
        map.put(root, val);

        return val;
    }
}
