package CoinPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 656. Coin Path
 *
 * Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B.
 * The integer B denotes that from any place (suppose the index is i) in the array A,
 * you can jump to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to.
 *
 * Also, if you step on the index i, you have to pay Ai coins.
 * If Ai is -1, it means you can’t jump to the place indexed i in the array.
 *
 * Now, you start from the place indexed 1 in the array A,
 * and your aim is to reach the place indexed N using the minimum coins.
 *
 * You need to return the path of indexes (starting from 1 to N) in the array
 * you should take to get to the place indexed N using minimum coins.
 *
 * If there are multiple paths with the same cost, return the lexicographically smallest such path.
 * If it's not possible to reach the place indexed N then you need to return an empty array.
 */
public class CoinPath {
    // If there are two path to reach n, and they have the same optimal cost,
    // then the longer path is lexicographically smaller.
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] cost = new int[n];
        int[] prev = new int[n];
        int[] steps = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        cost[0] = 0;
        for (int i=0; i<n; i++) {
            if (A[i] == -1) {
                continue;
            }
            for (int j=Math.max(0, i-B); j<i; j++) {
                if (A[j] == -1) {
                    continue;
                }
                int alt = cost[j] + A[j];
                if (alt < cost[i] || alt == cost[i] && steps[j]+1 > steps[i]) {
                    cost[i] = alt;
                    steps[i] = steps[j]+1;
                    prev[i] = j;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int i=n-1; i>=0; i=prev[i]) {
            path.add(0, i+1);
        }
        return path.get(0) != 1 ? Collections.emptyList() : path;
    }
}
