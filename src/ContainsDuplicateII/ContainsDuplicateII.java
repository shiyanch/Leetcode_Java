package ContainsDuplicateII;

import java.util.Hashtable;

/**
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 *
 * Testcases: [1,0,1,1], 1 -> True
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable hashtable = new Hashtable();

        for(int i=0;i<nums.length;i++) {
            if(hashtable.containsKey(nums[i]))
                if (k >= (i-(int)hashtable.get(nums[i])))
                    return true;
                else {
                    hashtable.remove(nums[i]);
                }

            hashtable.put(nums[i],i);
        }

        return false;
    }
}
