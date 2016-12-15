package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, m = words[0].length();
        List<Integer> res = new ArrayList();
        /*Store string array with hashtable.*/
        HashMap<String, Integer> map = new HashMap();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        /*m is the length of each word in array words, each time get a substring of length m to check if it exits in words*/
        for (int i = 0; i <= s.length()-n*m; i++) {
            HashMap<String, Integer> copy = new HashMap(map);
        	/*if it exits, use another hashset to avoid duplicate and count the number to reach n, the number of words in array words*/
            int k = n, j = i;
            while (k > 0) {
                String str = s.substring(j, j+m);
                if (!copy.containsKey(str) || copy.get(str) < 1) break;
                copy.put(str, copy.get(str)-1);
                k--; j+=m;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"ab", "ba", "ba"};
        String s = "ababaab";
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));

    }
}
