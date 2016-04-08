package RotateImage;

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] newMatrix = new int[length][length];

        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                newMatrix[i][j] = matrix[length-1-j][i];

        for(int i=0;i<length;i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
