package SpiralMatrixII;

/**
 * 59. Spiral Matrix II
 *
 * Given an integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][];
        for(int i=0;i<n;i++)
            matrix[i] = new int[n];

        if(n == 0)
            return matrix;

        if(n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }

        int status = 1;
        int count = 1;
        int i=0,j=0;
        matrix[0][0] = count++;
        while (count <= n*n && i>=0 && i<n && j>=0 && j<n) {
            switch (status) {
                case 1:
                    if(j<n-1 && matrix[i][j+1] == 0) {
                        matrix[i][++j] = count++;
                    }
                    else
                        status = 2;
                    break;
                case 2:
                    if(i<n-1 && matrix[i+1][j] == 0) {
                        matrix[++i][j] = count++;
                    }
                    else
                        status = 3;
                    break;
                case 3:
                    if(j>0 && matrix[i][j-1] == 0) {
                        matrix[i][--j] = count++;
                    }
                    else
                        status = 4;
                    break;
                case 4:
                    if(i>0 && matrix[i-1][j] == 0) {
                        matrix[--i][j] = count++;
                    }
                    else
                        status = 1;
                    break;
                default:
                    break;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(1);
    }
}
