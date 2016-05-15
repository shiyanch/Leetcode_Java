package CountCompleteTreeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int leftDepth = sideDepth(root, "left");
        int rightDepth = sideDepth(root, "right");

        if(leftDepth == rightDepth)
            return (1<<leftDepth) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int sideDepth(TreeNode root, String flag) {
        int dep = 0;
        while(root != null) {
            dep++;
            if(flag.equals("left"))
                root = root.left;
            else
                root = root.right;
        }
        return dep;
    }


    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;

        int count = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            count+=size;
            while(size-- > 0) {
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
        }
        return count;
    }

    public int countNodes3(TreeNode root) {
        if(root == null)
            return 0;

        recursiveCount(root, 0);
        array.trimToSize();
        Integer[] res = new Integer[array.size()];
        array.toArray(res);

        int maxLayer = res[0];
        int lastLayerNodes = 0;
        for(int i=0;i<res.length;i++) {
            if(res[i] != maxLayer)
                break;
            else
                lastLayerNodes++;
        }

        int sum = 0;
        for(int i=0;i<maxLayer;i++) {
            sum += Math.pow(2,i);
        }

        sum += lastLayerNodes;
        return sum;

    }

    private ArrayList<Integer> array = new ArrayList<>();
    private void recursiveCount(TreeNode root, int tempCount) {
        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            this.array.add(tempCount);
            return;
        }

        if(root.left != null)
            recursiveCount(root.left, tempCount+1);

        if(root.right != null)
            recursiveCount(root.right, tempCount+1);
    }

    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);



        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;

        System.out.println(countNodes2(node1));
        System.out.println(countNodes(node1));
    }
}
