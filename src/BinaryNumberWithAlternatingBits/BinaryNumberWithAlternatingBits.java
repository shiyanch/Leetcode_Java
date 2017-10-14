package BinaryNumberWithAlternatingBits;

/**
 * 693. Binary Number with Alternating Bits
 *
 * Given a positive integer, check whether it has alternating bits:
 * namely, if two adjacent bits will always have different values.
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i=1; i<binary.length(); i++) {
            if (binary.charAt(i-1) == binary.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
