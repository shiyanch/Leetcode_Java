package CourseSchedule;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 207. Course Schedule
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 *
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0.
 * So it is possible.
 *
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1.
 * So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] isVisited = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(isVisited[i] != 2 && !dfs(prerequisites, isVisited, i))
                return false;
        }
        return true;
    }

    private static boolean dfs(int[][] prerequisites, int[] isVisited, int start) {
        if(isVisited[start] == 1)
            return false;

        isVisited[start] = 1;
        for(int i=0;i<prerequisites.length;i++) {
            if(prerequisites[i][0] == start && isVisited[prerequisites[i][1]] != 2)
                if(!dfs(prerequisites, isVisited, prerequisites[i][1]))
                    return false;
        }
        isVisited[start] = 2;
        return true;
    }
}
