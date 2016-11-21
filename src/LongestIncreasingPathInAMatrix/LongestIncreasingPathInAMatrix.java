package LongestIncreasingPathInAMatrix;

/**
 * 329. Longest Increasing Path in a Matrix
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary
 * (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInAMatrix {
    // Recommended Methods to handle directions
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int longestPath = 1;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                longestPath = Math.max(longestPath, dfs(matrix, cache, i, j, m, n));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j, int m, int n) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int longestPath = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, cache, x, y, m, n);
            longestPath = Math.max(longestPath, len);
        }
        cache[i][j] = longestPath;
        return cache[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix));
    }
}
