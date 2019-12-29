package KthLargestElementInAStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 *
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 */
public class KthLargestElementInAStream {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t));
        this.k = k;
        Arrays.stream(nums).forEach(this::add);
    }

    public int add(int val) {
        if (minHeap.size()  < k) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}
