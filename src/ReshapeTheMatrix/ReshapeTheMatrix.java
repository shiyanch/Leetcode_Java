package ReshapeTheMatrix;

/**
 * 566. Reshape the Matrix
 *
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number
 * and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements
 * of the original matrix in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int index = 0;
        int[][] arr = new int[r][];
        for (int i=0; i<r; i++) {
            arr[i] = new int[c];
            for (int j=0; j<c; j++, index++) {
                arr[i][j] = nums[index/col][index%col];
            }
        }
        return arr;
    }
}
