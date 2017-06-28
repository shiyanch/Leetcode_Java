package OutOfBoundaryPaths;

/**
 * 576. Out of Boundary Paths
 *
 * There is an m by n grid with a ball.
 *
 * Given the start coordinate (i,j) of the ball,
 * you can move the ball to adjacent cell or cross the grid boundary in four directions
 * (up, down, left, right).
 *
 * However, you can at most move N times.
 * Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 10^9 + 7.
 */
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] grid = new long[2][m][n];
        while (N-- > 0) {
            for (int k=0; k<m; k++) {
                for (int l=0, nc=(N+1)%2, np=N%2; l<n; l++) {
                    grid[nc][k][l] = (
                            (k==0?1:grid[np][k-1][l]) +
                                    (k==m-1?1:grid[np][k+1][l]) +
                                    (l==0?1:grid[np][k][l-1]) +
                                    (l==n-1?1:grid[np][k][l+1])
                    ) % 1000000007;
                }
            }
        }
        return (int)grid[1][i][j];
    }
}
