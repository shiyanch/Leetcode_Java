package LicenseKeyFormatting;

/**
 * 482. License Key Formatting
 *
 * Now you are given a string S,
 * which represents a software license key which we would like to format.
 *
 * The string S is composed of alphanumerical characters and dashes.
 * The dashes split the alphanumerical characters within the string into groups.
 * (i.e. if there are M dashes, the string is split into M+1 groups).
 *
 * The dashes in the given string are possibly misplaced.
 * We want each group of characters to be of length K
 * (except for possibly the first group, which could be shorter,
 * but still must contain at least one character).
 *
 * To satisfy this requirement, we will reinsert dashes.
 * Additionally, all the lower case letters in the string must be converted to upper case.
 *
 * Example 1:
 * Input: S = "2-4A0r7-4k", K = 4
 * Output: "24A0-R74K"
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 *
 * Note:
 * The length of string S will not exceed 12,000, and K is a positive integer.
 * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 * String S is non-empty.
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String str, int k) {
        str = str.toUpperCase().replaceAll("-", "");
        if (str.length() == 0) {
            return str;
        }
        int start = str.length() % k;
        StringBuilder sb = new StringBuilder();
        if (start != 0) {
            sb.append(str.substring(0, start)+"-");
        }
        while (start <= str.length() - k) {
            sb.append(str.substring(start, start + k));
            sb.append("-");

            start += k;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
