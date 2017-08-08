package PrintBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. Print Binary Tree
 *
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 *
 * The column and the row where the root node belongs will separate the rest space into two parts
 * (left-bottom part and right-bottom part).
 *
 * You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
 * The left-bottom part and the right-bottom part should have the same size.
 *
 * Even if one subtree is none while the other is not,
 * you don't need to print anything for the none subtree
 * but still need to leave the space as large as that for the other subtree.
 *
 * However, if two subtrees are none,
 * then you don't need to leave space for both of them.
 *
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 */
public class PrintBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int[] size = getSize(root);
        int m = size[0];
        int n = size[1];
        System.out.println(m+" "+n);
        List<List<String>> result = new ArrayList<>(m);
        printTree(root, result, 0, 0, n-1, m, n);
        return result;
    }

    private void printTree(TreeNode root, List<List<String>> result, int level, int start, int end, int m, int n) {
        if (root == null || level == m || start > end) {
            return;
        }
        List<String> list;
        if (result.size() <= level) {
            list = new ArrayList<>(n);
            for (int i=0; i<n; i++) {
                list.add("");
            }
            result.add(list);
        } else {
            list = result.get(level);
        }
        int mid = (start+end)/2;
        list.set(mid, String.valueOf(root.val));
        printTree(root.left, result, level+1, start, mid-1, m, n);
        printTree(root.right, result, level+1, mid+1, end, m, n);
    }

    // [height, width]
    private int[] getSize(TreeNode root) {
        if (root == null) {
            return new int[] {0,0};
        }

        int[] left = getSize(root.left);
        int[] right = getSize(root.right);
        int height = Math.max(left[0], right[0]) + 1;
        int width = 2*Math.max(left[1], right[1]) + 1;
        return new int[] {height, width};
    }
}
