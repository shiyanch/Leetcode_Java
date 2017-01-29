package SlidingWindowMedian;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 480. Sliding Window Median
 *
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Long> larger = new PriorityQueue<>();
        PriorityQueue<Long> smaller = new PriorityQueue<>();
        double[] medians = new double[nums.length-k+1];

        for (int i=0; i<nums.length; i++) {
            if (i >= k) {
                // 必须先转换为long类型，再进行remove，否则会删除不掉！！
                if (nums[i-k] < larger.peek()) {
                    smaller.remove(-(long)nums[i-k]);
                }
                else {
                    larger.remove((long)nums[i-k]);
                }
            }
            larger.offer((long)nums[i]);
            smaller.offer(-larger.poll());
            if (smaller.size() > larger.size()) {
                larger.offer(-smaller.poll());
            }
            if (i >= k-1) {
                medians[i-k+1] = getMedian(larger, smaller);
            }
        }
        return medians;
    }

    private double getMedian(PriorityQueue<Long> larger, PriorityQueue<Long> smaller) {
        if (larger.size() > smaller.size()) {
            return larger.peek();
        }
        else return (larger.peek()-smaller.peek())/2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Long> maxHeap = new PriorityQueue<>();
        Queue<Long> minHeap = new PriorityQueue<>();
        double[] ans = new double[nums.length-k+1];
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (i >= k) {
                removeNum(maxHeap, minHeap, nums[i-k]);
            }
            addNum(maxHeap, minHeap, nums[i]);
            if (i >= k-1) {
                ans[index++] = getMedian(maxHeap, minHeap);
            }
        }
        return ans;
    }

    private void addNum(Queue<Long> maxHeap, Queue<Long> minHeap, int num) {
        maxHeap.offer((long)num);
        minHeap.offer(-maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(-minHeap.poll());
        }
    }

    private void removeNum(Queue<Long> maxHeap, Queue<Long> minHeap, int num) {
        if (num >= getMedian(maxHeap, minHeap)) {
            maxHeap.remove((long)num);
        }
        else {
            // 先转换再-，否则溢出
            minHeap.remove(-(long)num);
        }
    }

    private double getMedian(Queue<Long> maxHeap, Queue<Long> minHeap) {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (maxHeap.peek()-minHeap.peek())/2.0;
        }
        else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        double[] ans = new SlidingWindowMedian().medianSlidingWindow2(
                new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3);
//        double[] ans = new SlidingWindowMedian().medianSlidingWindow2(
//                new int[] {1,3,-1,-3,5,3,6,7}, 3);
        for (double n : ans) {
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
