package NaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 */
public class NaryTreePreorderTraversal {
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        for (Node child : root.children) {
            preorder(child, result);
        }
    }
}
