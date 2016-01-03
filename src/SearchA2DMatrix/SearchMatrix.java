package SearchA2DMatrix;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * For example,
 * Consider the following matrix:
 * [
 *     [1,   3,  5,  7],
 *     [10, 11, 16, 20],
 *     [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] array = new int[m*n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                array[i*n + j] = matrix[i][j];
            }
        }

        int mid, left=0, right=array.length-1;

        while (left <= right) {
            mid = (left+right) >> 1;

            if(array[mid] > target) right=mid-1;
            else if (array[mid] < target) left=mid+1;
            else return true;
        }

        return false;
    }
}
