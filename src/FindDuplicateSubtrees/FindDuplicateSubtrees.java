package FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 *
 * Given a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees,
 * you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 */
public class FindDuplicateSubtrees {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<String, Integer>(), res);
        return res;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + helper(root.left, map, list) + "," + helper(root.right, map, list);
        if (map.getOrDefault(serial, 0) <= 1) {
            if (map.getOrDefault(serial, 0) == 1) {
                list.add(root);
            }
            map.put(serial, map.getOrDefault(serial, 0) + 1);
        }
        return serial;
    }
}
