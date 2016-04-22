package KthSmallestElementInABST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree
 * write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * Hint:
 * Try to utilize the property of a BST.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // O(n) complexity
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        System.out.println(list);
        return list.get(k-1);
    }

    // O(k) complexity
    public int kthSmallest2(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                list.add(cur.val);
                if(list.size() == k)
                    return cur.val;
                cur = cur.right;
            }
        }
        return list.get(k-1);
    }

}

