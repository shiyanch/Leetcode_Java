package SingleNumber;
import java.util.HashSet;

/**
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet hashSet = new HashSet();

        for (int i: nums) {
            if(!hashSet.contains(i))
                hashSet.add(i);
            else
                hashSet.remove(i);
        }
        return (int) hashSet.toArray()[0];
    }
}
