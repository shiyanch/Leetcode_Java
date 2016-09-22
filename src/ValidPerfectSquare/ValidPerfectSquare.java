package ValidPerfectSquare;

/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num,
 * write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 0)
            return false;
        int left = 0, right = num;

        while(left <= right) {
            long mid = (left + right) >>> 1;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = (int)mid+1;
            else
                right = (int)mid-1;
        }
        return false;
    }

    // Newton Method
    public boolean isPerfectSquare2(int num) {
        long r = num;
        while(r * r > num)
            r = (r + num/r)/2;

        return r*r == num;
    }
}
