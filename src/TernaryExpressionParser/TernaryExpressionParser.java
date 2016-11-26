package TernaryExpressionParser;

/**
 * 439. Ternary Expression Parser
 *
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression.
 *
 * You can always assume that the given expression is valid
 * and only consists of digits 0-9, ?, :, T and F
 * (T and F represent True and False respectively).
 *
 * Note:
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 */
public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        StringBuffer sb = new StringBuffer(expression);
        while(sb.indexOf("?") != -1) {
            int index = sb.lastIndexOf("?")-1;
            char ans = sb.charAt(index) == 'T' ? sb.charAt(index+2) : sb.charAt(index+4);
            sb.replace(index, index+5, ans+"");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new TernaryExpressionParser().parseTernary("T?T?F:5:3"));
    }
}
