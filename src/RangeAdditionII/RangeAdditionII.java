package RangeAdditionII;

/**
 * 598. Range Addition II
 *
 * Given an m * n matrix M initialized with all 0's and several update operations.
 *
 * Operations are represented by a 2D array,
 * and each operation is represented by an array with two positive integers a and b,
 * which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 *
 * You need to count and return the number of
 * maximum integers in the matrix after performing all the operations.
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }

        return m*n;
    }
}
