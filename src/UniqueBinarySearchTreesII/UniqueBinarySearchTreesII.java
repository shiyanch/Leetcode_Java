package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n,
 * generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) {
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start > end) {
            trees.add(null);
            return trees;
        }

        if(start == end) {
            trees.add(new TreeNode(start));
            return trees;
        }


        for(int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftSubTrees = helper(start, rootValue-1);
            List<TreeNode> rightSubTrees = helper(rootValue+1, end);

            for(TreeNode leftSubTree : leftSubTrees) {
                for(TreeNode rightSubTree : rightSubTrees) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}

