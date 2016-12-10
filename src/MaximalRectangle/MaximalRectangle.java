package MaximalRectangle;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 6.
 */
public class MaximalRectangle {
    // 每次更新left，right，height，将矩形范围进行缩小
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i=0;i<m;i++) {
            int currLeft = 0;
            int currRight = n;
            for (int j=0;j<n;j++) {
                height[j] = (matrix[i][j] == '1')?height[j]+1:0;
                left[j] = (matrix[i][j] == '1')?Math.max(left[j], currLeft):0;
                currLeft = (matrix[i][j] == '1')?currLeft:j+1;

                right[n-j-1] = (matrix[i][n-j-1] == '1')?Math.min(right[n-j-1], currRight):n;
                currRight = (matrix[i][n-j-1] == '1')?currRight:n-j-1;

            }

            for (int j=0;j<n;j++) {
                max = Math.max(max, (right[j]-left[j])*height[j]);
            }
        }
        return max;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int clen = matrix[0].length;
        int rlen = matrix.length;
        int[] h = new int[clen+1];
        h[clen] = 0;
        int max = 0;

        for (int row=0; row<rlen; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i<clen+1; i++) {
                if (i < clen) {
                    h[i] += (matrix[row][i] == '1')?1:-h[i];
                }

                if (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                    while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                        int top = stack.pop();
                        int area = h[top] * (stack.isEmpty()?i:(i-stack.peek()-1));
                        max = Math.max(max, area);
                    }
                }
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','1','0','1'}
                ,{'1','1','1','1','1','1'}
                ,{'0','1','1','0','1','1'}
                ,{'1','1','1','0','1','0'}
                ,{'0','1','1','1','1','1'}
                ,{'1','1','0','1','1','1'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
