package SearchA2DMatrixII;

/**
 * 240. Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * - Integers in each row are sorted in ascending from left to right.
 * - Integers in each column are sorted in ascending from top to bottom.
 *
 * Consider the following matrix:
 * [
 *  [1,   4,  7, 11, 15],
 *  [2,   5,  8, 12, 19],
 *  [3,   6,  9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row < matrix.length) {
            if(target == matrix[row][col]) {
                return true;
            }
            else if(target < matrix[row][col]) {
                col--;
            }
            else {
                row++;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        System.out.println(new SearchA2DMatrixII().searchMatrix(matrix, 13));
    }
}
