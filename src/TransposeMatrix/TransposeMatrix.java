package TransposeMatrix;

/**
 * 867. Transpose Matrix
 *
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposed = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
