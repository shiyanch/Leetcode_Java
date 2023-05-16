package LongestUncommonSubsequenceII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 522. Longest Uncommon Subsequence II
 *
 * Given an array of strings strs, return the length of the longest uncommon subsequence between them.
 * If the longest uncommon subsequence does not exist, return -1.
 *
 * An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
 *
 * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
 *
 * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
 * Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
        Set<String> duplicate = getDuplicatedStrings(strs);

        int index = strs.length - 1;
        while (index >= 0) {
            if (duplicate.contains(strs[index])) {
                index--;
                continue;
            }
            if (index == strs.length - 1) {
                return strs[index].length();
            }
            for (int i = index + 1; i < strs.length; i++) {
                if (isSubsequence(strs[i], strs[index])) {
                    break;
                }
                if (i == strs.length - 1) {
                    return strs[index].length();
                }
            }
            index--;
        }
        return -1;
    }

    private Set<String> getDuplicatedStrings(String[] strs) {
        Set<String> set = new HashSet<>();
        Set<String> duplicate = new HashSet<>();
        for (String str : strs) {
            if (set.contains(str)) {
                duplicate.add(str);
            } else {
                set.add(str);
            }
        }
        return duplicate;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == b.length();
    }

    public static void main(String[] args) {
        String[] array = {"aabbcc", "aabbcc", "ac"};
//        String[] array = {"aabbcc", "aabbcc", "cb"};
//        String[] array = {"aabbcc", "aabbcc", "acb", "acb", "cb"};
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(array));
    }
}
