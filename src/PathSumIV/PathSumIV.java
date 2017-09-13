package PathSumIV;

import java.util.Arrays;

/**
 * 666. Path Sum IV
 *
 * If the depth of a tree is smaller than 5,
 * then this tree can be represented by a list of three-digits integers.
 *
 * For each integer in this list:
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *
 * The tens digit represents the position P of this node in the level it belongs to,
 * 1 <= P <= 8. The position is the same as that in a full binary tree.
 *
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
 * You need to return the sum of all paths from the root towards the leaves.
 */
public class PathSumIV {
    public int pathSum(int[] nums) {
        int[] nodes = new int[15];
        Arrays.fill(nodes, -1);
        for (int num : nums) {
            int depth = num/100;
            int pos = num%100/10;
            int value = num%100%10;
            nodes[(int)Math.pow(2, depth-1)+pos-2] = value;
        }

        return dfs(nodes, 0, 0);
    }

    private int dfs(int[] nodes, int index, int sum) {
        if (index >= nodes.length || nodes[index] == -1) {
            return -1;
        }

        int left = dfs(nodes, 2*index+1, sum+nodes[index]);
        int right = dfs(nodes, 2*index+2, sum+nodes[index]);

        if (left == -1 && right == -1) {
            return sum+nodes[index];
        }
        int res = 0;
        if (left != -1) {
            res += left;
        }

        if (right != -1) {
            res += right;
        }
        return res;
    }
}
