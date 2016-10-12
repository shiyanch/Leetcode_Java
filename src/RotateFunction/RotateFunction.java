package RotateFunction;

/**
 * 396. Rotate Function
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise,
 * we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int[] factor = new int[2*A.length];
        for(int i=0;i<factor.length;i++) {
            if(i<A.length)
                factor[i] = i;
            else
                factor[i] = i-A.length;
        }

        long max = Long.MIN_VALUE;
        // i for offset
        for(int i=0;i<A.length;i++) {
            int sum = 0;
            for(int j=0;j<A.length;j++) {
                sum += factor[i+j]*A[j];
            }
            max = Math.max(max, sum);
        }

        return (int)max;
    }
}
