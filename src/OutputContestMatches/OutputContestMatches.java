package OutputContestMatches;

import java.util.LinkedList;
import java.util.List;

/**
 * 544. Output Contest Matches
 *
 * The n teams are given in the form of positive integers from 1 to n,
 * which represents their initial rank.
 *
 * (Rank 1 is the strongest team and Rank n is the weakest team.)
 * We'll use parentheses('(', ')') and commas(',')
 * to represent the contest team pairing - parentheses('(' , ')') f
 * or pairing and commas(',') for partition.
 *
 * During the pairing process in each round,
 * you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 */
public class OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> list = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            list.add(i+"");
        }

        while(list.size() > 1) {
            List<String> cur = new LinkedList<>();
            for (int i=0; i<list.size()/2; i++) {
                cur.add("("+list.get(i)+","+list.get(list.size()-i-1)+")");
            }
            list = cur;
        }

        return list.get(0);
    }
}
