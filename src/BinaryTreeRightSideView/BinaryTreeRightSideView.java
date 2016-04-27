package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Given a binary tree
 * imagine yourself standing on the right side of it
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            while(size-- > 0) {
                cur = queue.poll();
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            list.add(cur.val);
        }
        return list;
    }

    // DFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null)
            dfs(root, list, 0);

        return list;
    }

    private void dfs(TreeNode root, List<Integer> list, int level) {
        if(root == null)
            return;

        // first arrive, first add to result
        if(list.size() == level) {
            list.add(root.val);
        }

        // first right, then left
        // save a lot of time
        if(root.right != null)
            dfs(root.right, list, level+1);
        if(root.left != null)
            dfs(root.left, list, level+1);
    }

}
