package EmployeeImportance;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. Employee Importance
 *
 * You are given a data structure of employee information,
 * which includes the employee's unique id,
 * his importance value and his direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2,
 * and employee 2 is the leader of employee 3.
 *
 * They have importance value 15, 10 and 5, respectively.
 * Then employee 1 has a data structure like [1, 15, [2]],
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
 *
 * Note that although employee 3 is also a subordinate of employee 1,
 * the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id,
 * you need to return the total importance value of this employee and all his subordinates.
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return helper(map, id);
    }

    private int helper(Map<Integer, Employee> map, int id) {
        int sum = map.get(id).importance;
        for (int subordinate : map.get(id).subordinates) {
            sum += helper(map, subordinate);
        }
        return sum;
    }

}
