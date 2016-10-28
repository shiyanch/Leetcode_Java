package MinimumWindowSubstring;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T,
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * If there is no such window in S that covers all characters in T,
 * return the empty string "".
 */
public class MinimumWindowSubstring {
    public String minWindows(String s, String t) {
        String minWinSubstr = "";
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
            return minWinSubstr;
        }

        int[] hash = new int[256];
        for(char c : t.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = t.length();

        while (right < s.length()) {
            if(hash[s.charAt(right++)]-- > 0) {
                count--;
            }

            while (count == 0) {
                if(minWinSubstr.equals("") || right-left < minWinSubstr.length())
                    minWinSubstr = s.substring(left, right);
                if(hash[s.charAt(left++)]++ == 0)
                    count++;
            }

        }

        return minWinSubstr;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindows("adobecodebanc", "abc"));
    }
}
