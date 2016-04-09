package SetMatrixZeros;

/**
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeros {
    public void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0;i<m;i++) {
            if(row[i] == 1) {
                for(int j=0;j<n;j++)
                    matrix[i][j] = 0;
            }
        }

        for(int j=0;j<n;j++) {
            if(col[j] == 1) {
                for(int i=0;i<m;i++)
                    matrix[i][j] = 0;
            }
        }
    }

    public void setZeros2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row=false, col=false;

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    if(i==0)
                        col = true;
                    if(j==0)
                        row = true;


                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }

        for(int i=1;i<m;i++) {
            if(matrix[i][0] == 0) {
                for(int j=1;j<n ;j++)
                    matrix[i][j] = 0;
            }
        }

        for(int j=1;j<n;j++) {
            if(matrix[0][j]==0) {
                for(int i=1;i<m ;i++)
                    matrix[i][j] = 0;
            }
        }

        if(row)
            for(int j=0;j<n;j++)
                matrix[0][j] = 0;

        if(col)
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;


        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        System.out.println("\n=====================\n");
    }
}
