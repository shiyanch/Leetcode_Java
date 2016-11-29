package AdditiveNumber;

import java.math.BigInteger;

/**
 * 306. Additive Number
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers.
 *
 * Except for the first two numbers,
 * each subsequent number in the sequence must be the sum of the preceding two.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i=1; i<=num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j=1; Math.max(i, j) <= num.length()-i-j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }

                BigInteger x2 = new BigInteger(num.substring(i, j+i));
                if (isValid(x1, x2, j+i, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) {
            return true;
        }

        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start+sum.length(), num);
    }

    public boolean isAdditiveNumber_iterative(String num) {
        for (int i=1; i<=num.length()/2; i++) {
            for (int j=1; Math.max(i, j) <= num.length()-i-j; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if((num.charAt(0) == '0' && i > 1) || (num.charAt(i) == '0' && j > 1)) {
            return false;
        }

        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i+j));
        for (int start = i+j; start != num.length(); start += sum.length()) {
            x2 = x2+x1;
            x1 = x2-x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
