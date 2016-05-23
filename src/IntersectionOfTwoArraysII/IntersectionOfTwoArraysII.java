package IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk,
 * and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
            arrayList1.add(nums1[i]);

        for(int i=0;i<nums2.length;i++) {
            if(arrayList1.contains(nums2[i])) {
                arrayList1.remove(new Integer(nums2[i]));
                arrayList2.add(nums2[i]);
            }
        }

        int[] res = new int[arrayList2.size()];
        for(int i=0;i<res.length;i++)
            res[i] = arrayList2.get(i);

        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        List<Integer> list = new ArrayList<>();

        while (i<nums1.length && j<nums2.length) {
            while (i<nums1.length && j<nums2.length && nums1[i]<nums2[j])
                i++;

            while (i<nums1.length && j<nums2.length && nums1[i]>nums2[j])
                j++;

            while (i<nums1.length && j<nums2.length && nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];

        for(i=0;i<list.size();i++)
            res[i] = list.get(i);

        return res;
    }
}
