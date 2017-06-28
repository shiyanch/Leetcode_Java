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
        // The number of paths for N moves is the sum of paths for N - 1 moves from the adjacent cells.
        // If an adjacent cell is out of the border, the number of paths is 1.
        // We only need to look one step back.
        // We can use N % 2 and (N + 1) % 2 to alternate grids so we do not have to copy.
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
