package BombEnemy;

/**
 * 361. Bomb Enemy
 *
 * Given a 2D grid, each cell is either a wall 'W',
 * an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 *
 * The bomb kills all the enemies in the same row and column from the planted point
 * until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];

        for (int i=0; i<m; i++) {
            int left = 0;
            int right = 0;
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 'E') {
                    left++;
                }
                else if (grid[i][j] == 'W') {
                    left = 0;
                }
                else {
                    matrix[i][j] += left;
                }

                if (grid[i][n-j-1] == 'E') {
                    right++;
                }
                else if (grid[i][n-j-1] == 'W') {
                    right = 0;
                }
                else {
                    matrix[i][n-j-1] += right;
                }
            }
        }

        int count = 0;
        for (int j=0; j<n; j++) {
            int upper = 0;
            int lower = 0;
            for (int i=0; i<m; i++) {
                if (grid[i][j] == 'E') {
                    upper++;
                }
                else if (grid[i][j] == 'W') {
                    upper = 0;
                }
                else {
                    matrix[i][j] += upper;
                }

                if (grid[m-i-1][j] == 'E') {
                    lower++;
                }
                else if (grid[m-i-1][j] == 'W') {
                    lower = 0;
                }
                else {
                    matrix[m-i-1][j] += lower;
                }
                count = Math.max(count, Math.max(matrix[m-i-1][j], matrix[i][j]));
            }
        }
        return count;
    }
}
