package ExclusiveTimeOfFunctions;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 *
 * Given the running logs of n functions that
 * are executed in a nonpreemptive single threaded CPU,
 * find the exclusive time of these functions.
 *
 * Each function has a unique id, start from 0 to n-1.
 * A function may be called recursively or by another function.
 *
 * A log is a string has this format : function_id:start_or_end:timestamp.
 * For example, "0:start:0" means function 0 starts from the very beginning of time 0.
 * "0:end:0" means function 0 ends to the very end of time 0.
 *
 * Exclusive time of a function is defined as the time spent within this function,
 * the time spent by calling other functions should not be considered as this function's exclusive time.
 * You should return the exclusive time of each function sorted by their function id.
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime;
                stack.push(Integer.parseInt(parts[0]));
                prevTime = Integer.parseInt(parts[2]);
            }
            else {
                res[stack.pop()] += 1 + Integer.parseInt(parts[2]) - prevTime;
                prevTime = 1 + Integer.parseInt(parts[2]);
            }
        }
        return res;
    }
}
