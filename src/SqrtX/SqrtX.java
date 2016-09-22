package SqrtX;

/**
 * 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class SqrtX {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if(mid * mid == x)
                return (int)mid;
            else if(mid*mid < x)
                left = (int)mid+1;
            else
                right = (int)mid-1;
        }

        return right;
    }
}
