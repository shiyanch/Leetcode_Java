package PermutationSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 60. Permutation Sequence
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {
    // https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/4
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1;i<=n;i++) {
            numbers.add(i);
            factorial[i] = i*factorial[i-1];
        }

        StringBuilder sb = new StringBuilder();
        k--;

        for(int i=1;i<=n;i++) {
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n-i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(5,2));
    }
}
