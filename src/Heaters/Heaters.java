package Heaters;

import java.util.Arrays;

/**
 * 475. Heaters
 *
 * Winter is coming! Your first job during the contest is
 * to design a standard heater with fixed warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately,
 * and your expected output will be the minimum radius standard of heaters.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index-1>=0 ? house - heaters[index-1] : Integer.MAX_VALUE;
                int dist2 = index<heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                radius = Math.max(radius, Math.min(dist1, dist2));
            }
        }
        return radius;
    }
}
