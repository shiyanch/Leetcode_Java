package MultiplyStrings;

/**
 * 43. Multiply Strings
 *
 * Given two numbers represented as strings,
 * return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];

        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + res[i+j+1];

                res[i+j] += sum / 10;
                res[i+j+1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r : res) {
            // omit the heading zeros
            if(!(sb.length() == 0 && r == 0)) {
                sb.append(r);
            }
        }

        return sb.length() == 0?"0":sb.toString();
    }
}
