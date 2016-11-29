package PalindromePermutationII;

import java.util.ArrayList;
import java.util.List;

/**
 * 267. Palindrome Permutation II
 *
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        int[] dict = new int[256];
        if (!makeDict(s, dict)) {
            return result;
        }
        String mid = "";
        for (int i = 0; i < 256; i++) {
            char key = (char) i;
            if (dict[i] % 2 != 0) {
                mid = key+"";
            }

            for (int j=0;j<dict[i]/2;j++) {
                list.add(key);
            }
        }
        generatePerm(result, list, new boolean[list.size()], mid, new StringBuilder());
        return result;
    }

    private void generatePerm(List<String> result, List<Character> list, boolean[] used, String mid, StringBuilder sb) {
        if (sb.length() == list.size()) {
            result.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse(); // reverse back to original string
            return;
        }

        for (int i=0; i<list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i-1) && !used[i-1]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                generatePerm(result, list, used, mid, sb);
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }



    public boolean makeDict(String s, int[] dict) {
        for (char c : s.toCharArray()) {
            dict[c]++;
        }

        boolean foundOdd = false;
        for (int i : dict) {
            if (i % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                else {
                    foundOdd = true;
                }
            }
        }
        return true;
    }
}
