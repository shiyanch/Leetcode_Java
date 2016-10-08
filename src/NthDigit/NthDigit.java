package NthDigit;

/**
 * 400. Nth Digit
 *
 * Find the nth digit of the infinite integer sequence
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        int count = 9;

        while(n > len*count) {
            n -= len*count;
            len++;
            count*=10;
        }

        count = count/9 + (n-1)/len;
        String s = Integer.toString(count);
        return Character.getNumericValue(s.charAt((n-1)%len));
    }
}
