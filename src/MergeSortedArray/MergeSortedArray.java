package MergeSortedArray;

import SummaryRanges.SummaryRanges;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2
 * merge nums2 into nums1 as one sorted array.
 *
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] backupNums1 = new int[m];
        for(int i=0;i<m;i++)
            backupNums1[i] = nums1[i];

        int index1 = 0, index2 = 0, oriIndex = 0;
        while(index1<m && index2<n) {
            if(backupNums1[index1] <= nums2[index2]) {
                nums1[oriIndex] = backupNums1[index1];
                index1++;
            }
            else {
                nums1[oriIndex] = nums2[index2];
                index2++;
            }
            oriIndex++;
        }

        if(index1 == m) {
            for(;index2<n;index2++,oriIndex++)
                nums1[oriIndex] = nums2[index2];
        }

        if(index2 == n) {
            for(;index1<m;index1++,oriIndex++)
                nums1[oriIndex] = backupNums1[index1];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int ind = n+m-1;
        int p1 = m-1;
        int p2 = n-1;

        while(ind >= 0) {
            if(p1<0)
                nums1[ind--] = nums2[p2--];
            else if(p2<0)
                nums1[ind--] = nums1[p1--];
            else
                nums1[ind--] = (nums1[p1]>nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
    }
}
