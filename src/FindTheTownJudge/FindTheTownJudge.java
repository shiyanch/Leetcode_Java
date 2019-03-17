package FindTheTownJudge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 997. Find the Town Judge
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town
 * judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person
 * labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> trusted = new HashMap<>();
        Set<Integer> believeOthers = new HashSet<>();
        for (int[] pair : trust) {
            trusted.put(pair[1], trusted.getOrDefault(pair[1], 0)+1);
            believeOthers.add(pair[0]);
        }

        int judge = -1;
        for (int people = 1; people <= N; people++) {
            if (trusted.getOrDefault(people, 0) == N-1 && !believeOthers.contains(people)) {
                if (judge == -1) {
                    judge = people;
                } else {
                    return -1;
                }
            }
        }
        return judge;
    }
}
