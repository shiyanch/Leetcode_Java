package FractionAdditionAndSubtraction;

import java.util.stream.Stream;

/**
 * 592. Fraction Addition and Subtraction
 *
 * Given a string representing an expression of fraction addition and subtraction,
 * you need to return the calculation result in string format.
 *
 * The final result should be irreducible fraction.
 * If your final result is an integer, say 2,
 * you need to change it to the format of fraction that has denominator 1.
 * So in this case, 2 should be converted to 2/1.
 */
public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-,+])");
        String res = "0/1";
        for (String frac: fracs) {
            res = add(res, frac);
        }
        return res;
    }

    public String add(String frac1, String frac2) {
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0]*f2[1] + f1[1]*f2[0];
        int denom = f1[1]*f2[1];
        String sign = "";
        if (numer < 0) {
            sign = "-";
            numer *= -1;
        }
        return sign + numer/gcd(numer, denom) + "/" + denom/gcd(numer, denom);
    }

    private int gcd(int x, int y) {
        return x == 0 || y == 0 ? x+y : gcd(y, x%y);
    }
}
