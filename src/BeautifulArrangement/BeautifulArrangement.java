package BeautifulArrangement;

/**
 * 526. Beautiful Arrangement
 *
 * Suppose you have N integers from 1 to N.
 * We define a beautiful arrangement as an array
 * that is constructed by these N numbers successfully
 * if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 *
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 */
public class BeautifulArrangement {
    public int countArrangement(int N) {
        return dfs(N, 1, new boolean[N]);
    }

    private int dfs(int n, int i, boolean[] visited) {
        if (i == n+1) {
            return 1;
        }

        int sum = 0;
        for (int j=1; j<=n; j++) {
            if (!visited[j-1] && (j%i == 0 || i%j == 0)) {
                visited[j-1] = true;
                sum += dfs(n, i+1, visited);
                visited[j-1] = false;
            }
        }
        return sum;
    }
}
