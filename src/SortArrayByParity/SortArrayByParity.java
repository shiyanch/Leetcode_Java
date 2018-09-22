package SortArrayByParity;

/**
 * 905. Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A == null) {
            return new int[0];
        }

        int[] ans = new int[A.length];
        int left = 0, right = A.length-1;

        for (int i=0; i<A.length; i++) {
            if ((A[i] & 1) == 1) {
                ans[right--] = A[i];
            } else {
                ans[left++] = A[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 1, 3};

        SortArrayByParity parity = new SortArrayByParity();
        int[] ans = parity.sortArrayByParity(A);
        for (int a : ans) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
