package CheckIfNAndItsDoubleExist;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1346. Check If N and Its Double Exist
 *
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 *
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 *
 * Example 3:
 * Input: arr = [-1,0,0]
 * Output: true
 *
 * Example 4:
 *  * Input: arr = [-1,0]
 *  * Output: false
 */
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 0; i < arr.length && 2 * arr[i] <= arr[arr.length - 1]; i++) {
            if (set.contains(arr[i] * 2)) {
                if (arr[i] == 0) {
                    if (i < arr.length - 1 && arr[i + 1] == 0) {
                        return true;
                    } else {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
