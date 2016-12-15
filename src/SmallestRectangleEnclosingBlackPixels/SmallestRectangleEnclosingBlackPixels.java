package SmallestRectangleEnclosingBlackPixels;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 *
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 *
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 *
 * For example, given the following image:
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 *
 * If there are only one black pixel region,
 * then in a [projected] 1D array all the black pixels are connected.
 */
public class SmallestRectangleEnclosingBlackPixels {

    // Binary Search 1 ms
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int colMin = binarySearch(image, true, 0, y, 0, m, true);
        int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
        return (rowMax - rowMin) * (colMax - colMin);
    }


    private int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while(lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for(int i = min; i < max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if(inside == goLower) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    // DFS  4 ms
    private int left = Integer.MAX_VALUE;
    private int right = Integer.MIN_VALUE;
    private int top = Integer.MAX_VALUE;
    private int bottom = Integer.MIN_VALUE;

    public int minArea_dfs(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        dfs(image, x, y);
        return (right - left + 1) * (bottom - top + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] == '0') {
            return;
        }

        image[x][y] = '0';
        left = Math.min(left, y);
        right = Math.max(right, y);
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);

        dfs(image, x, y+1);
        dfs(image, x, y-1);
        dfs(image, x-1, y);
        dfs(image, x+1, y);
    }

    // Naive m*n 7 ms
    public int minArea_naive(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int m = image.length;
        int n = image[0].length;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (image[i][j] == '1') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        return (right - left + 1) * (bottom - top + 1);
    }

    public static void main(String[] args) {
        char[][] image = {{'0','0','1','0'},{'0','0','1','0'},{'0','1','1','1'}};
        System.out.println(new SmallestRectangleEnclosingBlackPixels().minArea(image, 2, 3));
    }
}
