package FairCandySwap;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. Fair Candy Swap
 *
 * Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes
 * where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of
 * candies of the jth box of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the
 * same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box
 * they have.
 *
 * Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and
 * answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return
 * any one of them. It is guaranteed that at least one answer exists.
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int size : aliceSizes) {
            aliceSum += size;
            set.add(size);
        }

        for (int size : bobSizes) {
            bobSum += size;
        }

        int diff = (aliceSum - bobSum) / 2;
        for (int size : bobSizes) {
            if (set.contains(size + diff)) {
                return new int[] {size + diff, size};
            }
        }
        return null;
    }
}
