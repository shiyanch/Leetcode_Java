package NumberComplement;

/**
 * 476. Number Complement
 *
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int factor = 1;
        int res = 0;
        while (num != 0) {
            res += factor * ((num%2 == 0)?1:0);
            factor *= 2;
            num /= 2;
        }
        return res;

        // To find complement of num = 5 which is 101 in binary.
        // First ~num gives ...11111010 but we only care about the right most 3 bits.
        // Then to erase the 1s before 010 we can add 1000
        // return ~num + (Integer.highestOneBit(num) << 1);
    }
}
