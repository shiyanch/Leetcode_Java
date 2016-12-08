package ValidNumber;

/**
 * 65. Valid Number
 *
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * If we see [0-9] we reset the number flags.
 * We can only see . if we didn't see e or ..
 * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
 * We can only see + and - in the beginning and after an e
 * any other character break the validation.
 * [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean digit = false;
        boolean number = false;
        boolean emark = false;
        boolean numberAfterE = false;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                number = true;
                numberAfterE = true;
            }
            else if (c == '.') {
                if (emark || digit) {
                    return false;
                }
                digit = true;
            }
            else if (c == 'e') {
                if (!number || emark) {
                    return false;
                }
                emark = true;
                numberAfterE = false;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return number && numberAfterE;
    }
}
