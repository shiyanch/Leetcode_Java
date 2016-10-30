package KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Build a minHeap of elements from the first row.
 * Do the following operations k-1 times :
 * 1. Every time when you poll out the root(Top Element in Heap),
 * 2. you need to know the row number and column number of that element,
 * 3. so we can create a tuple class here,
 * 4. replace that root with the next element from the same column.
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int i=0;i<n;i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for(int i=0;i<k-1;i++) {
            Tuple t = pq.poll();
            if(t.x == n-1)
                continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }

}
class Tuple implements Comparable<Tuple> {
    int x, y, val;

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
