package CheckDistancesBetweenSameLetters;

import java.util.Arrays;

/**
 * 2399. Check Distances Between Same Letters
 *
 * You are given a 0-indexed string s consisting of only lowercase English letters, where each letter in s appears
 * exactly twice. You are also given a 0-indexed integer array distance of length 26.
 *
 * Each letter in the alphabet is numbered from 0 to 25 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25).
 *
 * In a well-spaced string, the number of letters between the two occurrences of the ith letter is distance[i].
 * If the ith letter does not appear in s, then distance[i] can be ignored.
 *
 * Return true if s is a well-spaced string, otherwise return false.
 */
public class CheckDistancesBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {
        int[] map = new int[26];
        Arrays.fill(map, -1);

        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] == -1) {
                map[pos] = i;
            } else {
                if (distance[pos] != i - map[pos] -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
