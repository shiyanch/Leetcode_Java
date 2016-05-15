package RecoverBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * wo elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // bfs
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        TreeNode first = null;
        TreeNode second = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if((cur.left != null && cur.val < cur.left.val)
                || (cur.right != null && cur.val > cur.right.val)) {
                if(first == null)
                    first = cur;
                else {
                    second = cur;
                    break;
                }
            }

            if(cur.left != null)
                queue.add(cur.left);

            if(cur.right != null)
                queue.add(cur.right);
        }

        System.out.println(first.val+" "+second.val);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.right = node5;

        recoverTree(node4);
    }
}
