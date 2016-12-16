package CanIWin;

import java.util.*;

/**
 * 464. Can I Win
 *
 * In the "100 game," two players take turns adding,
 * to a running total, any integer from 1..10.
 *
 * The player who first causes the running total to reach or exceed 100 wins.
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of
 * numbers of 1..15 without replacement until they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal,
 * determine if the first player to move can force a win,
 * assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will
 * not be larger than 20 and desiredTotal will not be larger than 300.
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap <> ());
    }

    private boolean canIWin(int length, int total, int state, HashMap <Integer, Boolean> hashMap) {
        if (hashMap.containsKey(state)) return hashMap.get(state);
        for (int i = 0; i < length; i++) {
            if ((1 << i & state) == 0) {
                if (total <= i + 1 || !canIWin(length, total - (i + 1), 1 << i | state, hashMap)) {
                    hashMap.put(state, true);
                    return true;
                }
            }
        }
        hashMap.put(state, false);
        return false;
    }


    public boolean canIWin_original(int maxChoosableInteger, int desiredTotal) {
        // 判断下是否所有数都不能满足
        if ((maxChoosableInteger+1)*maxChoosableInteger/2 < desiredTotal) {
                return false;
        }

        Map<Integer, Boolean> cache = new HashMap<>();
        ArrayList<Boolean> choosableIntegers = new ArrayList<>(maxChoosableInteger+1);
        for (int i=0; i<=maxChoosableInteger; i++) {
            choosableIntegers.add(false);
        }
        return canIWin(choosableIntegers, desiredTotal, cache);
    }

    private boolean canIWin(ArrayList<Boolean> chossableIntegers, int remain, Map<Integer, Boolean> cache) {
        if (cache.containsKey(chossableIntegers.hashCode())) {
            return cache.get(chossableIntegers.hashCode());
        }

        int min = 0;
        int max = 0;
        for (int i=1; i<chossableIntegers.size(); i++) {
            if (!chossableIntegers.get(i)) {
                min = i;
                break;
            }
        }

        for (int i=chossableIntegers.size()-1; i>=1; i--) {
            if (!chossableIntegers.get(i)) {
                max = i;
                break;
            }
        }

        if (max >= remain) {
            return true;
        }

        if (remain-min < max) {
            return false;
        }

        for (int i=1; i<chossableIntegers.size(); i++) {
            if (!chossableIntegers.get(i)) {
                chossableIntegers.set(i, true);
                if (!canIWin(chossableIntegers, remain-i, cache)) {
                    chossableIntegers.set(i, false);
                    cache.put(chossableIntegers.hashCode(), true);
                    return true;
                }
                chossableIntegers.set(i, false);
            }
        }
        cache.put(chossableIntegers.hashCode(), false);
        return false;
    }
}

