package CanPlaceFlowers;

/**
 * 605. Can Place Flowers
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1,
 * where 0 means empty and 1 means not empty), and a number n,
 * return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if ((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }

            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
