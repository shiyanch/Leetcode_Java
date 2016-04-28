package PopulatingNextRightPointersInEachNodeII;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 *
 * For example,
 *
 * Given the following binary tree,
 *      1
 *    /   \
 *   2    3
 *  / \    \
 * 4  5    7
 *
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        root.next = null;

        while(root.left != null || root.right != null || root.next != null) {
            while(root != null && root.left == null && root.right == null)
                root = root.next;

            if(root == null)
                return;

            TreeLinkNode parent = root;
            TreeLinkNode first = null;

            while(parent != null) {
                if(parent.left != null) {
                    if(first == null)
                        first = parent.left;
                    else {
                        first.next = parent.left;
                        first = first.next;
                    }

                    if(parent.right != null) {
                        first.next = parent.right;
                        first = first.next;
                    }
                } else if(parent.right != null){
                    if(first == null)
                        first = parent.right;
                    else {
                        first.next = parent.right;
                        first = first.next;
                    }
                }

                parent = parent.next;
            }

            if(root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    public void test() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node6.right = node8;


        connect(node1);

    }
}
