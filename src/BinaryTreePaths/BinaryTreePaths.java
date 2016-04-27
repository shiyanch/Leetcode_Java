package BinaryTreePaths;

import java.util.*;

/**
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *
 *   1
 *  / \
 * 2   3
 *  \
 *   5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();

        if(root != null)
            buildPath(root, "", res);

        return res;
    }

    private void buildPath(TreeNode root, String path, List<String> res) {
        if(root.left == null && root.right == null)
            res.add(path+root.val);
        if(root.left != null)
            buildPath(root.left, path+root.val+"->", res);
        if(root.right != null)
            buildPath(root.right, path+root.val+"->", res);
    }
}
