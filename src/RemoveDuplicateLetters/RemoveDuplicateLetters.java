package RemoveDuplicateLetters;

/**
 * 316. Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 *
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example:
 * Given "bcabc"
 * Return "abc"
 *
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i=0; i<s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
    }
}
