package FlattenBinaryTreeToLinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                list.add(p);
                p = p.left;
            }
            else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }

        for(int i=0;i<list.size()-1;i++) {
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i+1);
        }
    }
}
