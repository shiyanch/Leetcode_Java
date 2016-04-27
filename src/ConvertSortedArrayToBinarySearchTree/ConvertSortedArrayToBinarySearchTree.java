package ConvertSortedArrayToBinarySearchTree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order
 * convert it to a height balanced BST.
 *
 * Testcases:
 * []                           -> []
 * [1]                          -> [1]
 * [1,2]                        -> [1,null,2]
 * [1,2,3]                      -> [2,1,3]
 * [1,2,3,4,5,6,7,8,9,10]       -> [5,2,8,1,3,6,9,null,null,null,4,null,7,null,10]
 * [1,2,3,4,5,6,7,8,9,10,11]    -> [6,3,9,1,4,7,10,null,2,null,5,null,8,null,11]
 */
public class ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);

        int mid = nums.length/2 + nums.length%2 -1;
        int[] left = new int[mid];
        int[] right = new int[nums.length-mid-1];

        for(int i=0;i<mid;i++) {
            left[i] = nums[i];
            right[i] = nums[mid+1+i];
        }
        right[right.length-1] = nums[nums.length-1];

        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = sortedArrayToBST(left);
        cur.right = sortedArrayToBST(right);

        return cur;
    }
}

