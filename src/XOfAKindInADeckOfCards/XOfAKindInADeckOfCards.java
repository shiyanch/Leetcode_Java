package XOfAKindInADeckOfCards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 914. X of a Kind in a Deck of Cards
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 *
 * Example 2:
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false´
 * Explanation: No possible partition.
 *
 * Example 3:
 * Input: deck = [1]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 4:
 * Input: deck = [1,1]
 * Output: true
 * Explanation: Possible partition [1,1].
 *
 * Example 5:
 * Input: deck = [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2].
 *
 * Example 6:
 * Input: deck = [1,1,1,1,2,2,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[1,1],[2,2],[2,2],[2,2]
 */
public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> dict = new HashMap<>();
        int max = -1;
        for (int card : deck) {
            dict.put(card, dict.getOrDefault(card, 0) + 1);
            max = Math.max(max, dict.get(card));
        }

        List<Integer> sortedCount = dict.values().stream().sorted().collect(Collectors.toList());
        if (sortedCount.get(0) < 2) {
            return false;
        }

        for (int i = 2; i <= max; i++) {
            boolean dividable = true;

            for ( int count : sortedCount) {
                if (count % i != 0) {
                    dividable = false;
                    break;
                }
            }
            if (dividable) {
                return true;
            }
        }

        return false;
    }
}
