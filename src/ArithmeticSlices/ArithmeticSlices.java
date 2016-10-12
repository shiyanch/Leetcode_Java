package ArithmeticSlices;

/**
 * 413. Arithmetic Slices
 *
 * A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 *
 * A zero-indexed array A consisting of N numbers is given.
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int sum = 0;
        int len = 2;

        for(int i=2;i<A.length;i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                len++;
            }
            else {
                if(len > 2) {
                    sum += calculateSlices(len);
                }
                len = 2;
            }
        }

        if(len>2)
            sum += calculateSlices(len);

        return sum;
    }

    private int calculateSlices(int n){
        return (n-1)*(n-2)/2;
    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[] {1,2,3,4}));
    }
}
