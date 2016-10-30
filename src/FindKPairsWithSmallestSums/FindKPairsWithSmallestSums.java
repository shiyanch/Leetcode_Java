package FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array
 * and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return list;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

        for(int i=0;i<nums2.length;i++) {
            pq.offer(new Tuple(0, i, nums1[0]+nums2[i]));
        }

        for(int i=0;i<Math.min(k,nums1.length*nums2.length);i++) {
            Tuple t = pq.poll();
            list.add(new int[] {nums1[t.x], nums2[t.y]});
            if(t.x == nums1.length-1)
                continue;
            pq.offer(new Tuple(t.x+1, t.y, nums1[t.x+1]+nums2[t.y]));
        }

        return list;
    }
}

class Tuple implements Comparable<Tuple> {
    final int x,y,val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple other) {
        return this.val - other.val;
    }
}
