package GroupThePeopleGivenTheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. Group the People Given the Group Size They Belong To
 *
 * There are n people that are split into some unknown number of groups.
 * Each person is labeled with a unique ID from 0 to n - 1.
 *
 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
 * For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
 *
 * Return a list of groups such that each person i is in a group of size groupSizes[i].
 *
 * Each person should appear in exactly one group, and every person must be in a group.
 * If there are multiple answers, return any of them.
 * It is guaranteed that there will be at least one valid solution for the given input.
 *
 * Example:
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!groupMap.containsKey(groupSizes[i])) {
                groupMap.put(groupSizes[i], new ArrayList<>());
            }
            groupMap.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int groupSize : groupMap.keySet()) {
            int index = 0;
            List<Integer> candidates = groupMap.get(groupSize);
            while (index < candidates.size()) {
                result.add(candidates.subList(index, index + groupSize));
                index += groupSize;
            }
        }
        return result;
    }
}
