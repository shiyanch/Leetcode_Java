package RangeSumQuery2DImmutable;

/**
 * 304. Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix,
 * find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DImmutable {
    private final int[][] sum;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            sum = null;
            return;
        }

        sum = new int[matrix.length+1][matrix[0].length+1];

        for (int i=0; i<matrix.length; i++) {
            int tmp = 0;
            for (int j=0; j<matrix[0].length; j++) {
                tmp += matrix[i][j];
                sum[i+1][j+1] = sum[i][j+1] + tmp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null || sum.length == 0)
            return 0;
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
