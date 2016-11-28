package OneEditDistance;

/**
 * 161. One Edit Distance
 *
 * Given two strings S and T,
 * determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() == 0 || t.length() == 0) {
            return Math.abs(s.length() - t.length()) == 1;
        }

        int i=0;
        for (i=0; i<Math.min(s.length(), t.length());i++) {
            if (s.charAt(i) != t.charAt(i)) {
                StringBuffer insert = new StringBuffer(s);
                if (insert.insert(i, t.charAt(i)+"").toString().equals(t)) {
                    return true;
                }
                StringBuffer delete = new StringBuffer(s);
                if (delete.deleteCharAt(i).toString().equals(t)) {
                    return true;
                }
                StringBuffer replace = new StringBuffer(s);
                if (replace.replace(i, i+1, t.charAt(i)+"").toString().equals(t)) {
                    return true;
                }
                return false;
            }
        }
        return s.length() - i == 1 || t.length() - i == 1;
    }
}
