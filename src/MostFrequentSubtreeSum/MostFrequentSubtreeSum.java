package MostFrequentSubtreeSum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as
 * the sum of all the node values formed by the subtree rooted
 * at that node (including the node itself).
 *
 * So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 */
public class MostFrequentSubtreeSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> records = new HashMap<>();
        calSubSum(root, records);
        int maxTimes = 0;
        List<Integer> res = new LinkedList<>();
        for (int key : records.keySet()) {
            if (records.get(key) > maxTimes) {
                maxTimes = records.get(key);
                res = new LinkedList<>();
                res.add(key);
            }
            else if (records.get(key) == maxTimes) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int calSubSum(TreeNode root, Map<Integer, Integer> records) {
        if (root == null) {
            return 0;
        }

        int left = calSubSum(root.left, records);
        int right = calSubSum(root.right, records);
        int sum = left + right + root.val;
        records.put(sum, records.getOrDefault(sum, 0)+1);
        return sum;
    }
}
