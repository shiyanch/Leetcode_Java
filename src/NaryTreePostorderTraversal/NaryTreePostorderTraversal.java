package NaryTreePostorderTraversal;

import NaryTreePreorderTraversal.NaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 */
public class NaryTreePostorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postorder(child, result);
        }
        result.add(root.val);
    }
}
