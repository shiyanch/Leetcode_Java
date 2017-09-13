package ImageSmoother;

/**
 * 661. Image Smoother
 *
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell
 * becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 *
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 */
public class ImageSmoother {
    int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1}, {1,0}, {1,1}};
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return M;
        }
        int m = M.length;
        int n = M[0].length;
        int[][] image = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int sum = 0;
                int count = 0;
                for (int[] dir : dirs) {
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if (isValid(m, n, x, y)) {
                        sum += M[x][y];
                        count++;
                    }
                }
                image[i][j] = sum/count;
            }
        }
        return image;
    }

    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
