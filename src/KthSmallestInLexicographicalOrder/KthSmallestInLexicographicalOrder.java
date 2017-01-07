package KthSmallestInLexicographicalOrder;

/**
 * 440. K-th Smallest in Lexicographical Order
 *
 * Given integers n and k,
 * find the lexicographically k-th smallest integer in the range from 1 to n.
 * Note: 1 ≤ k ≤ n ≤ 109.
 */
public class KthSmallestInLexicographicalOrder {
    private int count = 0;
    public int findKthNumber(int n, int k) {
        //count = 0;
        //return dfs(n, k, 0);
        int curr = 1;
        k = k-1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr+1);
            if (steps <= k) {
                curr++;
                k -= steps;
            }
            else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    // 十叉树一层上的数字是连续的
    private int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n+1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }



    // tle
    private int dfs(int n, int k, int cur) {
        if (cur > n || count > k) {
            return -1;
        }
        if (cur != 0) {
            count++;
        }

        if (count == k) {
            return cur;
        }

        for (int i=0;i<10;i++) {
            if (cur == 0 && i == 0) {
                continue;
            }
            if (cur*10 + i > n) {
                break;
            }
            int res = dfs(n, k, cur*10+i);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(13,6));
    }
}
