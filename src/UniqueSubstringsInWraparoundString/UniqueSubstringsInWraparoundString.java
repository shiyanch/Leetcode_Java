package UniqueSubstringsInWraparoundString;

/**
 * 467. Unique Substrings in Wraparound String
 *
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 *
 * Now we have another string p.
 * Your job is to find out how many unique non-empty substrings of p are present in s.
 * In particular, your input is the string p and
 * you need to output the number of different non-empty substrings of p in the string s.
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int currentMaxLen = 0;
        char[] s = p.toCharArray();
        for (int i=0; i<s.length; i++) {
            if (i > 0 && (s[i] == s[i-1]+1 || s[i] == 'a' && s[i-1] == 'z')) {
                currentMaxLen++;
            }
            else {
                currentMaxLen = 1;
            }
            count[s[i]-'a'] = Math.max(count[s[i]-'a'], currentMaxLen);
        }

        int sum = 0;
        for (int c : count) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
}
