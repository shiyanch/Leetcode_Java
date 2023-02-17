package MaximumValueOfAStringInAnArray;

/**
 * 2496. Maximum Value of a String in an Array
 *
 * The value of an alphanumeric string can be defined as:
 *
 * The numeric representation of the string in base 10, if it comprises of digits only.
 * The length of the string, otherwise.
 * Given an array strs of alphanumeric strings, return the maximum value of any string in strs.
 */
public class MaximumValueOfAStringInAnArray {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            max = Math.max(max, calculateValue(str));
        }
        return max;
    }

    private static int calculateValue(String str) {
        int intValue = 0;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                intValue = intValue * 10 + (c - '0');
            } else {
                return str.length();
            }
        }
        return intValue;
    }
}
