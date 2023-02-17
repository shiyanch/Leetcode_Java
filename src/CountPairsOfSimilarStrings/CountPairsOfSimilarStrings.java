package CountPairsOfSimilarStrings;

import java.util.*;

/**
 * 2506. Count Pairs Of Similar Strings
 *
 * You are given a 0-indexed string array words.
 *
 * Two strings are similar if they consist of the same characters.
 *
 * For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
 * However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
 * Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.
 */
public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        Map<Set<Character>, Integer> map = new HashMap<>();
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            map.put(set, map.getOrDefault(set, 0) + 1);
        }

        return map.values().stream().mapToInt(this::combinations).sum();
    }

    private int combinations(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "helo", "hheelo"};
        System.out.println(new CountPairsOfSimilarStrings().similarPairs(words));
    }
}
