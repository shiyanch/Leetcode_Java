package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        /*
        case 1: [0,1,2,4,5,7]
        result: ["0->2","4->5","7"]

        case 2: [0]
        result: ["0"]

        case 3: [0,2]
        result: ["0","2"]

        case 3: [0,1,2]
        result: ["0->2"]

        case 4: [0,1,2,4,6,8,9]
        result: ["0->2","4","6","8->9"]

        case 5: [0,1,2,4,6,8,9,11]
        result: ["0->2","4","6","8->9","11"]

         */

        List<String> result = new ArrayList<String>();

        int begin,last;
        begin = 0;
        last = 1;

        if(nums.length == 1)
            result.add(""+nums[begin]);

        while(last < nums.length) {
            if (nums[last] == nums[last - 1] + 1) {
                if (last == nums.length - 1)
                    result.add(nums[begin] + "->" + nums[last]);
            } else {
                if (last - begin == 1)
                    result.add("" + nums[begin]);
                else
                    result.add(nums[begin] + "->" + nums[last - 1]);

                begin = last;

                if (begin == nums.length - 1)
                    result.add("" + nums[begin]);
            }

            last++;
        }
        return result;
    }
}
