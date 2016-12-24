package SerializeAndDeserializeBST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST
 *
 * Serialization is the process of converting a data structure or object
 * into a sequence of bits so that it can be stored in a file or memory buffer,
 *
 * or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();

        if(root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                res.append(cur.val+" ");
                queue.add(cur.left);
                queue.add(cur.right);
            }
            else
                res.append("null ");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;

        String[] datas = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));

        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(index < datas.length) {
            TreeNode cur = queue.poll();
            if(!datas[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(datas[index]));
                cur.left = left;
                queue.add(left);
            }

            index++;

            if(index < datas.length && !datas[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(datas[index]));
                cur.right = right;
                queue.add(right);
            }

            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        String code = new SerializeAndDeserializeBST().serialize(root);
        System.out.println(code);
        TreeNode newRoot = new SerializeAndDeserializeBST().deserialize(code);
    }
}
