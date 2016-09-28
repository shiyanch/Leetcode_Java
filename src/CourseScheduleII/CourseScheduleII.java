package CourseScheduleII;

import java.util.ArrayList;

/**
 * 210. Course Schedule II
 *
 * There are a total of n courses you have to take,
 * labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0.
 * So the correct course order is [0,1]
 *
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take.
 * To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 *
 * So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] isVisited = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(isVisited[i] != 2 && !dfs(prerequisites, isVisited, i, list))
                return new int[] {};
        }

        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i] = list.get(i);

        return res;
    }

    private static boolean dfs(int[][] prerequisites, int[] isVisited, int start, ArrayList<Integer> list) {
        if(isVisited[start] == 1)
            return false;

        isVisited[start] = 1;
        for(int i=0;i<prerequisites.length;i++) {
            if(prerequisites[i][0] == start && isVisited[prerequisites[i][1]] != 2)
                if(!dfs(prerequisites, isVisited, prerequisites[i][1], list))
                    return false;
        }
        isVisited[start] = 2;
        list.add(start);
        return true;
    }
}
