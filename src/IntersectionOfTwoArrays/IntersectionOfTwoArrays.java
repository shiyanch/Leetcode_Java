package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> array = new ArrayList<>();

        for(int i:nums1)
            if(!set.contains(i))
                set.add(i);

        for(int i:nums2)
            if(set.contains(i) && !array.contains(i))
                array.add(i);

        int[] res = new int[array.size()];
        for(int i=0;i<array.size();i++)
            res[i] = array.get(i).intValue();


        return res;
    }
}
