package BeautifulArrangementII;

/**
 * 667. Beautiful Arrangement II
 *
 * Given two integers n and k,
 * you need to construct a list which contains n different positive integers ranging from 1 to n
 * and obeys the following requirement:
 *
 * Suppose this list is [a1, a2, a3, ... , an],
 * then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 *
 * If there are multiple answers, print any of them.
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0? l++ : r--);
        return res;
    }
}
