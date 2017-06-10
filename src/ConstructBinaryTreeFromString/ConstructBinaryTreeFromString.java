package ConstructBinaryTreeFromString;

import java.util.Stack;

/**
 * 536. Construct Binary Tree from String
 *
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * The whole input represents a binary tree.
 * It contains an integer followed by zero, one or two pairs of parenthesis.
 * The integer represents the root's value and
 * a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 *       4
 *     /   \
 *    2     6
 *  / \   /
 * 3   1 5
 */
public class ConstructBinaryTreeFromString {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        String[] nums = s.split("[()]+");
        String parenthesis = s.replaceAll("-?[0-9]+", "");

        stack.push(new TreeNode(Integer.parseInt(nums[0])));
        int i = 1;
        for (char c: parenthesis.toCharArray()) {
            if (c == '(') {
                TreeNode cur = new TreeNode(Integer.parseInt(nums[i++]));
                stack.push(cur);
            }
            else {
                TreeNode cur = stack.pop();
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = cur;
                }
                else {
                    parent.right = cur;
                }
            }
        }
        return stack.pop();
    }
}
