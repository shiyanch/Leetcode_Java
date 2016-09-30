package MedianOfTwoSortedArrays;

/**
 * 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        boolean odd = (len%2 == 1);

        int i=0,j=0;
        int count=0;
        int[] merged = new int[len];
        while (i<nums1.length && j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                merged[count++] = nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                merged[count++] = nums2[j];
                j++;
            }
            else {
                merged[count] = merged[count+1] = nums1[i];
                i++;
                j++;
                count+=2;
            }

            if(count > len/2) {
                if(odd)
                    return merged[len/2];
                else
                    return (merged[len/2-1]+merged[len/2])/2.0;
            }
        }

        if(i == nums1.length) {
            if(odd)
                return nums2[len/2-count+j];
            else {
                int prev = len/2 - count - 1 >= 0?nums2[len/2 - count - 1 + j]:merged[count-1];
                return (nums2[len/2 - count+j] + prev) / 2.0;
            }
        }

        if(odd)
            return nums1[len/2-count+i];
        else {
            int prev = len/2 - count -1 >= 0?nums1[len/2 - count - 1 + i]:merged[count-1];
            return (nums1[len/2 - count+i] + prev) / 2.0;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int count = 0;
        int i=0,j=0;
        int prev=0;
        while (count < len/2 && i<nums1.length && j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                prev = nums1[i++];
            }
            else {
                prev = nums2[j++];
            }
            count++;
        }


        while (count<len/2 && i<nums1.length) {
            prev = nums1[i++];
            count++;
        }

        while (count<len/2 && j<nums2.length) {
            prev = nums2[j++];
            count++;
        }

        if(len%2 == 1) {
            if(i == nums1.length)
                return nums2[j];
            if(j == nums2.length)
                return nums1[i];
            return (nums1[i]>nums2[j])?nums2[j]:nums1[i];
        }
        else {
            if(i == nums1.length)
                return (nums2[j]+prev)/2.0;
            if(j == nums2.length)
                return (nums1[i]+prev)/2.0;
            return (nums1[i]>nums2[j])?(nums2[j]+prev)/2.0:(nums1[i]+prev)/2.0;
        }
    }
}
