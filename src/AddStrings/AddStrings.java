package AddStrings;

/**
 * 415. Add Strings
 *
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int val = 0;
        for (int i1 = num1.length() - 1, i2 = num2.length() - 1;
             i1 >= 0 || i2 >= 0;
             i1--, i2--, val /= 10) {
            int n1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int n2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            val = n1 + n2 + val;
            sb.append(val % 10);
        }
        if (val > 0)
            sb.append(val);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("99", "99"));
    }
}
