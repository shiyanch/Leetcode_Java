package PowerOfFour;

/**
 * 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num < 0)
            return false;

        while (num >= 4) {
            int reminder = num % 4;
            if (reminder != 0) {
                return false;
            }

            num /= 4;
        }
        return (num == 1);
    }

    public boolean isPowerOfFour2(int num) {
        if(num < 0)
            return false;

        if(num >= 4) {
            if(num%4 != 0)
                return false;
            else
                return isPowerOfFour2(num/4);
        }
        else
            return (num == 1);
    }

    /**
     * The basic idea is from power of 2, We can use "n&(n-1) == 0" to determine if n is power of 2.
     * For power of 4, the additional restriction is that in binary form,
     * the only "1" should always located at the odd position.
     *
     * For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000.
     * So we can use "num & 0x5555555555555555L==num" to check if "1" is located at the odd position.
     */
    public boolean isPowerOfFour3(int num) {
        return (num>0) && ((num & (num-1)) == 0) && ((num & 0x5555555555555555L) == num);
    }
}
