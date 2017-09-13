package FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 *
 * Given a sorted array, two integers k and x,
 * find the k closest elements to x in the array.
 *
 * The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int index = binarySearch(arr, x);
        int left = index-1, right = index;
        while (list.size() < k) {
            if (left < 0) {
                list.add(arr.get(right++));
            } else if (right >= arr.size()) {
                list.add(0, arr.get(left--));
            } else {
                int leftDiff = Math.abs(arr.get(left) - x);
                int rightDiff = Math.abs(arr.get(right) - x);
                if (leftDiff <= rightDiff) {
                    list.add(0, arr.get(left--));
                } else {
                    list.add(arr.get(right++));
                }
            }
        }
        return list;
    }

    private int binarySearch(List<Integer> arr, int x) {
        int left = 0, right = arr.size()-1;
        while (left <= right) {
            int mid = (right-left)/2+left;
            if (arr.get(mid) >= x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
