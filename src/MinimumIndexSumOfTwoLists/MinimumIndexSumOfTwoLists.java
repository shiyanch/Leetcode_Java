package MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers,
 * output all of them with no order requirement.
 *
 * You could assume there always exists an answer.
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            String[] temp = list2;
            list2 = list1;
            list1 = temp;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i=0; i<list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    res = new ArrayList<>();
                    res.add(list2[i]);
                }
                else if (sum == min) {
                    res.add(list2[i]);
                }
            }
        }
        String[] result = new String[res.size()];
        for (int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
