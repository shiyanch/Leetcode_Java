package SetMismatch;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. Set Mismatch
 *
 * The set S originally contains numbers from 1 to n.
 * But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing.
 * Return them in the form of an array.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        int miss = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=nums.length; i++) {
            set.add(i);
        }

        for (int num: nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                dup = num;
            }
        }
        miss = set.iterator().next();
        return new int[] {dup, miss};
    }
}
