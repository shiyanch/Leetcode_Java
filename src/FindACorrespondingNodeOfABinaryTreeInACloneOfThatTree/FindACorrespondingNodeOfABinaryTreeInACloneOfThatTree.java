package FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 *
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 *
 * The cloned tree is a copy of the original tree.
 *
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a
 * reference to a node in the cloned tree.
 *
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val;}
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopyRecursively(original, cloned, target);
    }

    private TreeNode getTargetCopyRecursively(TreeNode currOriginal, TreeNode currCloned, TreeNode target) {
        if (currOriginal == target) {
            return currCloned;
        }

        if (currCloned.left != null) {
            TreeNode potential = getTargetCopyRecursively(currOriginal.left, currCloned.left, target);
            if (potential != null) {
                return potential;
            }
        }

        if (currCloned.right != null) {
            return getTargetCopyRecursively(currOriginal.right, currCloned.right, target);
        }

        return null;
    }
}
