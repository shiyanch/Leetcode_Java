package TheKWeakestRowsInAMatrix;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] r1, int[] r2) -> {
            if (r1[0] < r2[0]) {
                return -1;
            } else if (r1[0] == r2[0]) {
                return r1[1] - r2[1];
            } else {
                return 1;
            }
        });

        for (int i = 0; i < mat.length; i++) {
            pq.offer(rank(mat[i], i));
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

    private int[] rank(int[] row, int index) {
        int l = 0;
        int r = row.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] >= 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[] {l, index};
    }

    public static void main(String[] args) {
        TheKWeakestRowsInAMatrix theKWeakestRowsInAMatrix = new TheKWeakestRowsInAMatrix();
        int[] ans = theKWeakestRowsInAMatrix.kWeakestRows(new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
