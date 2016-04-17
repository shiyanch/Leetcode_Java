package BinaryTreePostorderTraversal;
import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Testcase:
 * [1,2,3,4,5,6,7,null,null,8,null,null,9] -> [4,8,5,2,9,6,7,3,1]
 */
public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        HashMap<TreeNode, Integer> visited = new HashMap<>();


        if (root == null)
            return list;

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (!visited.containsKey(cur)) {
                while (cur != null) {
                    stack.push(cur);
                    visited.put(cur, 0);
                    cur = cur.left;
                }
            }

            cur = stack.peek();

            if (visited.get(cur) == 0) {
                visited.replace(cur, 1);
                cur = cur.right;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                if(cur == root)
                    break;
            }
        }
        return list;
    }

    // concise solution
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.left = f;
        e.right = g;
        d.left = h;
        f.right = i;

        ArrayList<Integer> list = (ArrayList) postorderTraversal(a);
        System.out.println(list.toArray());

    }
}