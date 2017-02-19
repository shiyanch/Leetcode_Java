package Base7;

/**
 * 504. Base 7
 *
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 *
 * Example 2:
 * Input: -7
 * Output: "-10"
 *
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num = -num;
        }
        int factor = 1;
        while (factor * 7 <= num) {
            factor *= 7;
        }

        while (num != 0) {
            sb.append(num/factor);
            num %= factor;
            factor /= 7;
        }
        while (factor != 0) {
            sb.append(0);
            factor /= 7;
        }
        return sb.toString();
    }
}
