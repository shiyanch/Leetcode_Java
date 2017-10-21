package CountBinarySubstrings;

/**
 * 696. Count Binary Substrings
 *
 * Give a string s,
 * count the number of non-empty (contiguous) substrings
 * that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char prev = s.charAt(0);
        int count = 0;
        int sum = 0;
        int precount = 0;
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                sum += (precount != 0) ? Math.min(precount, count) : 0;
                precount = count;
                count = 1;
                prev = c;
            }
        }
        sum += (precount != 0) ? Math.min(precount, count) : 0;
        return sum;
    }
}
