package ComplexNumberMultiplication;

/**
 * 537. Complex Number Multiplication
 *
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi,
 * where the integer a and b will both belong to the range of [-100, 100].
 * And the output should be also in this form.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String A, String B) {
        int i = A.indexOf("+");
        int j = B.indexOf("+");
        int a = Integer.parseInt(A.substring(0, i));
        int b = Integer.parseInt(A.substring(i + 1, A.length() - 1));
        int c = Integer.parseInt(B.substring(0, j));
        int d = Integer.parseInt(B.substring(j + 1, B.length() - 1));

        int x = a * c - b * d;
        int y = b * c + a * d;
        return x + "+" + y + "i";
    }
}
