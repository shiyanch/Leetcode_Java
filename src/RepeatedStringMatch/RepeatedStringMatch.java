package RepeatedStringMatch;

/**
 * 686. Repeated String Match
 *
 * Given two strings A and B, find the minimum number of times A
 * has to be repeated such that B is a substring of it.
 *
 * If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”),
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int s = A.indexOf(B.charAt(0));
        while (s != -1) {
            int count = count(A, B, s);
            if (count != -1) {
                return count;
            }
            s = A.indexOf(B.charAt(0), s+1);
        }
        return -1;
    }

    private int count(String A, String B, int s) {
        int b = 0;
        while (b < B.length()) {
            int index = s % A.length();
            if (A.charAt(index) != B.charAt(b)) {
                return -1;
            }
            s++;
            b++;
        }

        return s%A.length()==0 ? s/A.length() : s/A.length()+1;
    }
}
