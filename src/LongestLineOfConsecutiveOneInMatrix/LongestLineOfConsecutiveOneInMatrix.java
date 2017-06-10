package LongestLineOfConsecutiveOneInMatrix;

/**
 * 562. Longest Line of Consecutive One in Matrix
 *
 * Given a 01 matrix M,
 * find the longest line of consecutive one in the matrix.
 *
 * The line could be horizontal, vertical, diagonal or anti-diagonal.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    private static final int[][] dirs = {{-1,-1}, {-1,0}, {0,-1}, {-1,1}};
    private static boolean isValid(int m, int n, int x, int y) {
        return x>=0 && x<m && y>=0 && y<n;
    }

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int[][][] records = new int[m][n][4];
        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                for (int t=0; t<dirs.length; t++) {
                    int x = i+dirs[t][0];
                    int y = j+dirs[t][1];
                    records[i][j][t] = !isValid(m, n, x, y) ? 1 : records[x][y][t] + 1;
                    max = Math.max(max, records[i][j][t]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] M = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        System.out.println(new LongestLineOfConsecutiveOneInMatrix().longestLine(M));
    }
}
