package EvaluateDivision;

import java.util.*;

/**
 * 399. Evaluate Division
 *
 * Equations are given in the format A / B = k,
 * where A and B are variables represented as strings,
 * and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(queries == null || queries.length == 0) {
            return new double[] {-1.0};
        }

        Set<String> words = new HashSet<>();
        String[][] newEquations = new String[equations.length*2][];
        double[] newValues = new double[values.length*2];
        for(int i=0;i<equations.length;i++) {
            words.add(equations[i][0]);
            words.add(equations[i][1]);

            newEquations[i] = new String[2];
            newEquations[i][0] = equations[i][0];
            newEquations[i][1] = equations[i][1];
            newValues[i] = values[i];

            newEquations[i+equations.length] = new String[2];
            newEquations[i+equations.length][0] = equations[i][1];
            newEquations[i+equations.length][1] = equations[i][0];
            newValues[i+equations.length] = 1.0/values[i];
        }

        equations = newEquations;
        values = newValues;

        double[] res = new double[queries.length];
        int index = 0;
        for(String[] query : queries) {
            if(query[0].equals(query[1])) {
                res[index] = words.contains(query[0])?1.0:-1.0;
            }
            else {
                res[index] = bfs(equations, values, query);
            }
            index++;
        }

        return res;
    }

    private double bfs(String[][] equations, double[] values, String[] query) {
        String above = query[0];
        String below = query[1];

        Set<String> visited = new HashSet<>();
        boolean[] edgeVisited = new boolean[equations.length];
        Queue<String> queue = new LinkedList<>();
        Queue<Double> tempRes = new LinkedList<>();
        queue.add(above);
        tempRes.add(1.0);

        while(!queue.isEmpty()) {
            String cur = queue.poll();
            double temp = tempRes.poll();
            visited.add(cur);
            for (int i = 0; i < equations.length; i++) {
                if (!edgeVisited[i] && equations[i][0].equals(cur)) {
                    edgeVisited[i] = true;
                    if(equations[i][1].equals(below))
                        return temp * values[i];

                    if(!visited.contains(equations[i][1])) {
                        queue.add(equations[i][1]);
                        tempRes.add(temp * values[i]);
                        visited.add(equations[i][1]);
                    }
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        String[][] equations = new String[][] {{"a","b"},{"e","b"},{"a","c"},{"ab","bc"}};
        double[] values = new double[] {2.0,3.0,4.0,5.0};
        String[][] query = new String[][] {{"a","e"},{"a","a"},{"bc","bc"},{"a","x"}};

        double[] res = evaluateDivision.calcEquation(equations, values, query);
        for(double i:res) {
            System.out.println(i);
        }

    }
}
