package ShortestPalindrome;

import java.util.Arrays;
import java.util.List;

/**
 * 214. Shortest Palindrome
 *
 * Given a string S,
 * you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public String shortestPalindrome_recursive(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end; char chs[] = s.toCharArray();
        while(i < j) {
            if (chs[i] == chs[j]) {
                i++; j--;
            } else {
                i = 0; end--; j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }


    public String shortestPalindrome_dp(String s) {
        boolean[][] pair = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j <= 1 || pair[j+1][i-1])) {
                    pair[j][i] = true;
                }
            }
        }

        int lastPair = -1;
        for (int i=0; i<s.length(); i++) {
            if (pair[0][i]) {
                lastPair = i;
            }
        }

        if (lastPair == s.length()-1) {
            return s;
        }
        return new StringBuilder(s.substring(lastPair+1)).reverse() + s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(new ShortestPalindrome().shortestPalindrome(s));
        List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5});
        System.out.println(list.toString());

    }
}
