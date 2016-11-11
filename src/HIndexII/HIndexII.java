package HIndexII;

/**
 * 275. H-Index II
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 */
public class HIndexII {
    public int hIndex(int[] citations) {
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

    public static void main(String[] args) {
        int[] citation = {1,2,3,4,5,6};
        System.out.println(new HIndexII().hIndex(citation));
    }
}
