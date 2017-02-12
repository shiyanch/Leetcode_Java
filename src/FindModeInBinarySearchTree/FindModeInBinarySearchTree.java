package FindModeInBinarySearchTree;

import java.util.*;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class FindModeInBinarySearchTree {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     Map<Integer, Integer> map;
     int max = 0;
     public int[] findMode(TreeNode root) {
         if(root==null) return new int[0];
         this.map = new HashMap<>();

         inorder(root);

         List<Integer> list = new LinkedList<>();
         for(int key: map.keySet()){
             if(map.get(key) == max) list.add(key);
         }

         int[] res = new int[list.size()];
         for(int i = 0; i<res.length; i++) res[i] = list.get(i);
         return res;
     }

     private void inorder(TreeNode node){
         if(node.left!=null) inorder(node.left);
         map.put(node.val, map.getOrDefault(node.val, 0)+1);
         max = Math.max(max, map.get(node.val));
         if(node.right!=null) inorder(node.right);
     }
}
