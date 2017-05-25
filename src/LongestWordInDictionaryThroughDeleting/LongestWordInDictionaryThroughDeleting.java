package LongestWordInDictionaryThroughDeleting;

import java.util.Collections;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 *
 * Given a string and a string dictionary,
 * find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 *
 * If there are more than one possible results,
 * return the longest word with the smallest lexicographical order.
 *
 * If there is no possible result, return the empty string.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        String res = "";
        for (String t : d) {
            if (isSubSequence(s, t) && res.length() < t.length()) {
                res = t;
            }
        }
        return res;
    }

    private boolean isSubSequence(String s, String t) {
        int i=0, j=0;

        while(i < s.length()) {
            if (j == t.length()) {
                return true;
            }

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }

        return j==t.length();
    }
}
