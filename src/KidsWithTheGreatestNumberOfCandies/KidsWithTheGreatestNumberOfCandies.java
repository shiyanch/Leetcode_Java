package KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 *
 * Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
 *
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the
 * greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
 */
public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
