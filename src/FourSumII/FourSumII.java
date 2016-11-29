package FourSumII;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 *
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are
 * such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier,
 * all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 *
 * All integers are in the range of -2^28 to 2^28 - 1
 * and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                count += map.getOrDefault(0 - c - d, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(new FourSumII().fourSumCount(A, B, C, D));
    }
}
