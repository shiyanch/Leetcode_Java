package PerfectSquares;

/**
 * 279. Perfect Squares
 *
 * Given a positive integer n,
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int x = (int)Math.sqrt(n);

        int[] squareNum = new int[x+1];
        for(int i=1;i<=x;i++)
            squareNum[i] = i*i;

        int[] res = new int[n+1];
        res[0] = 0;

        for(int i=1;i<=n;i++) {
            res[i] = Integer.MAX_VALUE;
            for(int j=1;j<=x;j++) {
                if(i >= squareNum[j])
                    res[i] = Math.min(res[i], res[i-squareNum[j]]+1);
            }
        }

        return res[n];
    }
}
