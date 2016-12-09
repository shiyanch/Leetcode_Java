package RangeSumQuery2DMutable;

/**
 * 308. Range Sum Query 2D - Mutable
 *
 * Given a 2D matrix matrix,
 * find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DMutable {
    private int[][] matrix;
    private int[][] colSums;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        this.matrix = matrix;
        int m   = matrix.length;
        int n   = matrix[0].length;
        colSums = new int[m + 1][n];
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i = row + 1; i < colSums.length; i++){
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for (int j=col1; j<=col2; j++) {
            ret += colSums[row2 + 1][j] - colSums[row1][j];
        }
        return ret;
    }
}
