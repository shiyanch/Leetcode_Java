package VerifyPreorderSerializationOfABinaryTree;

import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 *
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 *
 * Given a string of comma separated values,
 * verify whether it is a correct preorder traversal serialization of a binary tree.
 *
 * Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be
 * either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid,
 * for example it could never contain two consecutive commas such as "1,,3".
 */
public class VerifyPreorderSerializationOfABinaryTree {

    // 10ms computing in-degree and out-degree
    // all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
    // all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

    public boolean isValidSerialization_degree(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes) {
            if(--diff < 0) {
                return false;
            }
            if(!node.equals("#")) {
                diff += 2;
            }
        }

        return diff == 0;
    }



    // 31ms using stack
    public boolean isValidSerialization(String preorder) {

        if(preorder == null || preorder.length() == 0) {
            return false;
        }

        if(preorder.startsWith("#")) {
            return preorder.length() == 1;
        }

        Stack<String> stack = new Stack<>();
        Stack<Integer> children = new Stack<>();
        boolean finish = false;

        for(String s : preorder.split(",")) {
            if(finish) {
                return false;
            }
            if(s.equals("#")) {
                if(stack.isEmpty() || children.peek() == 2) {
                    return false;
                }
                else {
                    int child = children.pop()+1;
                    while (child == 2 && !stack.isEmpty()) {
                        stack.pop();

                        if(!children.isEmpty()) {
                            child = children.pop();
                        }
                        else child = 0;
                    }
                    children.push(child);
                    if(stack.isEmpty()) {
                        finish = true;
                    }
                }
            }
            else {
                stack.push(s);
                if(!children.isEmpty()) {
                    children.push(children.pop() + 1);
                }
                children.push(0);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String preorder = "1,#";
        System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization(preorder));
    }
}
