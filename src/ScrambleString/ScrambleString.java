package ScrambleString;

/**
 * 87. Scramble String
 *
 * Given a string s1, we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively.
 *
 * Given two strings s1 and s2 of the same length,
 * determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        int[] dict = new int[26];
        for (int i=0; i<s1.length(); i++) {
            dict[s1.charAt(i)-'a']++;
            dict[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) {
            if(dict[i] != 0) {
                return false;
            }
        }

        for (int i=1; i<s1.length();i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) {
                return true;
            }
        }
        return false;
    }
}
