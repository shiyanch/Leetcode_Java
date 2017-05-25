package KillProcess;

import java.util.*;

/**
 * 582. Kill Process
 *
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes.
 * This is just like a tree structure.
 *
 * Only one process has PPID that is 0, which means this process has no parent process.
 * All the PIDs will be distinct positive integers.
 *
 * We use two list of integers to represent a list of processes,
 * where the first list contains PID for each process and the second list contains the corresponding PPID.
 *
 * Now given the two lists, and a PID representing a process you want to kill,
 * return a list of PIDs of processes that will be killed in the end.
 *
 * You should assume that when a process is killed,
 * all its children processes will be killed.
 *
 * No order is required for the final answer.
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i=0; i<pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);

            if (parent != 0) {
                if (!tree.containsKey(parent)) {
                    tree.put(parent, new ArrayList<Integer>());
                }
                tree.get(parent).add(child);
            }
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            if (tree.containsKey(node)) {
                for (int child: tree.get(node)) {
                    queue.offer(child);
                }
            }
        }

        return result;
    }
}
