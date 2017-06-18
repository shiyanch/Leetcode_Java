package MaximumDistanceInArrays;

import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 *
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 */
public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() == 0) {
            return 0;
        }
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int result = 0;
        for (int i=1; i<arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int first = array.get(0);
            int last = array.get(array.size()-1);
            result = Math.max(result, Math.max(Math.abs(min-last), Math.abs(max-first)));
            min = Math.min(min, first);
            max = Math.max(max, last);
        }
        return result;
    }
}
