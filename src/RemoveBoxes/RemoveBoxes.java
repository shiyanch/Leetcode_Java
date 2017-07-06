package RemoveBoxes;

/**
 * 546. Remove Boxes
 *
 * Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left.
 * Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1),
 * remove them and get k*k points.
 *
 * Find the maximum points you can get.
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 */
public class RemoveBoxes {
    // https://discuss.leetcode.com/topic/84687/java-top-down-and-bottom-up-dp-solutions
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return remove(boxes, 0, n-1, 0, dp);
    }

    private int remove(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }

        int res = (k+1)*(k+1) + remove(boxes, i+1, j, 0, dp);
        for (int m=i+1; m<=j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, remove(boxes, i+1, m-1, 0, dp) + remove(boxes, m, j, k+1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }
}
