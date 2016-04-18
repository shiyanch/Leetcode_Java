package PowerOfTwo;

/**
 * 231. Power of Two
 * Given an integer
 * write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n & (n-1)) == 0);
    }

    public boolean isPowerOfTwo2(int n) {
        if(n <= 0)
            return false;
        while(n != 1) {
            if(n%2 != 0)
                return false;
            n /= 2;
        }

        return true;
    }

    public boolean isPowerOfTwo3(int n) {
        if(n <= 0 )
            return false;

        if(n == 1)
            return true;

        if(n %2 != 0)
            return false;
        else
            return isPowerOfTwo(n/2);
    }
}
