package HIndex;

import java.util.Arrays;

/**
 * 274. H-Index
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * For example, given citations = [3, 0, 6, 1, 5],
 * which means the researcher has 5 papers in total and
 * each of them had received 3, 0, 6, 1, 5 citations respectively.
 *
 * Since the researcher has 3 papers with at least 3 citations each
 * and the remaining two with no more than 3 citations each, his h-index is 3.
 */
public class HIndex {

    // 1ms
    // h最大也就是数组的长度
    public int hIndex(int[] citations) {
        int n = citations.length;
        int total = 0;
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++) {
            if(citations[i] > n) {
                arr[n]++;
            }
            else {
                arr[citations[i]]++;
            }
        }

        for(int i=n;i>=0;i--) {
            total += arr[i];
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex_2(int[] citations) {
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length-1;

        int last = 0;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if(citations[mid] >= citations.length - mid) {
                right = mid-1;
                last = mid;
            }
            else {
                left = mid+1;
            }
        }

        // in case of [0] and [0,0,...,0]
        return (citations[last] == 0)?0:citations.length - last;
    }

    // 3ms
    public int hIndex_3(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for(int i=citations.length-1;i>=0;i--) {
            if(citations[i] > count) {
                count++;
            }
            else return count;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[] {1,2,7,8,9}));
    }
}
