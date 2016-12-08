package FractionToRecurringDecimal;

import java.util.HashMap;

/**
 * 166. Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 * 做一次13/40的除法运算即可知规律
 * 把每次余数和对应的结果存在map里，如果当前余数出现过，则产生循环
 * 在之前那个余数的前面和当前string的末尾加上括号就是最终结果
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        long num = (long) numerator;
        long denom = (long) denominator;

        if (num % denom == 0) {
            return num/denom+"";
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        if ((num > 0 && denom < 0) || (num < 0 && denom > 0)) {
            sb.append("-");
        }
        num = Math.abs(num);
        denom = Math.abs(denom);
        sb.append(num/denom);
        sb.append(".");

        num = 10 * (num % denom);
        int index = 0;
        while (num != 0) {
            if (map.containsKey(num)) {
                int begin = sb.indexOf(".");
                sb.insert(begin+map.get(num)+1, "(");
                sb.insert(sb.length(), ")");
                break;
            }

            while (num < denom) {
                sb.append(0);
                map.put(num, index++);
                num *= 10;
            }

            long divided = num / denom;
            map.put(num, index++);
            sb.append(divided);
            num = 10 * (num % denom);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1,-2147483648));
        System.out.println(fractionToDecimal(2,1));
        System.out.println(fractionToDecimal(2,3));
        System.out.println(fractionToDecimal(40,13));
        System.out.println(fractionToDecimal(40,-13));
        System.out.println(fractionToDecimal(-40,13));
        System.out.println(fractionToDecimal(29,3));

    }
}
