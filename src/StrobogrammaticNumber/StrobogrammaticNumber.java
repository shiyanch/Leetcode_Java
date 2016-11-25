package StrobogrammaticNumber;

/**
 * 246. Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        StringBuffer sb = new StringBuffer();
        for (char c : num.toCharArray()) {
            if (c != '0' && c != '1' && c != '6' && c != '8' && c != '9') {
                return false;
            }
            if (c == '6') {
                sb.append("9");
                continue;
            }
            if (c == '9') {
                sb.append("6");
                continue;
            }
            sb.append(c);
        }
        return num.equals(sb.reverse().toString());
    }
}
