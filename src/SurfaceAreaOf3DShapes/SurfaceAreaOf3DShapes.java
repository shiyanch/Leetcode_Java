package SurfaceAreaOf3DShapes;

/**
 * 892. Surface Area of 3D Shapes
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 */
public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int surface = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                surface += 2; // Top and Bottom
                // Up-side
                if (i == 0 || grid[i][j] > grid[i - 1][j]) {
                    surface += (i == 0 ? grid[i][j] : grid[i][j] - grid[i - 1][j]);
                }
                // Down-side
                if (i == grid.length - 1 || grid[i][j] > grid[i + 1][j]) {
                    surface += (i == grid.length - 1 ? grid[i][j] : grid[i][j] - grid[i + 1][j]);
                }
                // Left-sdie
                if (j == 0 || grid[i][j] > grid[i][j - 1]) {
                    surface += (j == 0 ? grid[i][j] : grid[i][j] - grid[i][j - 1]);
                }
                // Right-side
                if (j == grid[i].length - 1 || grid[i][j] > grid[i][j + 1]) {
                    surface += (j == grid[i].length - 1 ? grid[i][j] : grid[i][j] - grid[i][j + 1]);
                }
            }
        }
        return surface;
    }
}
