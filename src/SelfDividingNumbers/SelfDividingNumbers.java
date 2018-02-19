package SelfDividingNumbers;

import java.util.LinkedList;
import java.util.List;


/**
 * 728. Self Dividing Numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound,
 * output a list of every possible self dividing number,
 * including the bounds if possible.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i=left; i<=right; i++) {
            if (isSelfDividingNumber(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isSelfDividingNumber(int num) {
        for (char c : (""+num).toCharArray()) {
            if (c == '0' || num % (c-'0') != 0) {
                return false;
            }
        }
        return true;
    }
}
