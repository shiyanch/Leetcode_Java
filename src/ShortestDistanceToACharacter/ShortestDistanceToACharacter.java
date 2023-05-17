package ShortestDistanceToACharacter;

import java.util.ArrayList;

/**
 * 821. Shortest Distance to a Character
 *
 * Given a string s and a character c that occurs in s, return an array of integers answer where
 * answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 *
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                pos.add(i);
            }
        }

        int[] res = new int[s.length()];
        int i = 0;
        int j = 0;
        while (i < pos.size()) {
            while (j <= pos.get(i)) {
                res[j] = pos.get(i) - j;
                j++;
            }

            if (i < pos.size() -1) {
                double mid = pos.get(i) + (pos.get(i+1) - pos.get(i)) / 2.0;
                while (j <= mid) {
                    res[j] = j - pos.get(i);
                    j++;
                }
            }
            i++;
        }

        while (j < res.length) {
            res[j] = j - pos.get(i - 1);
            j++;
        }

        return res;
    }
}
