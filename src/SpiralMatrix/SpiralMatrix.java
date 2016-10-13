package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null)
            return res;

        int status = 1;
        int count = 1;
        int i=0,j=0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] visited = new int[m][];
        for(int t=0;t<m;t++) {
            visited[t] = new int[n];
        }

        res.add(matrix[0][0]);
        visited[0][0] = 1;
        while (count < m*n && i>=0 && i<m && j>=0 && j<n) {
            switch (status) {
                case 1:
                    if(j<n-1 && visited[i][j+1] == 0) {
                        res.add(matrix[i][++j]);
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 2;
                    break;
                case 2:
                    if(i<m-1 && visited[i+1][j] == 0) {
                        res.add(matrix[++i][j]);
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 3;
                    break;
                case 3:
                    if(j>0 && visited[i][j-1] == 0) {
                        res.add(matrix[i][--j]);
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 4;
                    break;
                case 4:
                    if(i>0 && visited[i-1][j] == 0) {
                        res.add(matrix[--i][j]);
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 1;
                    break;
                default:
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[] {1,2,3};
        matrix[1] = new int[] {4,5,6};
        matrix[2] = new int[] {7,8,9};

        List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
        for(int i:list)
            System.out.print(i+" ");
    }
}
