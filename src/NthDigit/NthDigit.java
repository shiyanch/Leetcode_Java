package NthDigit;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int count = 1;
        StringBuffer sb = new StringBuffer();

        while(sb.length() < n) {
            sb.append(count++);
        }

        return sb.charAt(n-1)-'0';
    }
}
