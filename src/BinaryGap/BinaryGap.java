package BinaryGap;

/**
 * 868. Binary Gap
 *
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary
 * representation of n. If there are no two adjacent 1's, return 0.
 *
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the
 * absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 */
public class BinaryGap {
    public int binaryGap(int n) {
        int longest = 0;
        int count = -1;

        while (n > 0) {
            int remainder = n % 2;
            if (remainder == 1) {
                if (count != -1) {
                    longest = Math.max(longest, count);
                }
                count = 1;
            } else {
                if (count != -1)
                    count++;
            }
            n /= 2;
        }

        return longest;
    }
}
