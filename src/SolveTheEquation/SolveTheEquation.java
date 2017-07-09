package SolveTheEquation;

/**
 * 640. Solve the Equation
 *
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 * If there is no solution for the equation, return "No solution".
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        int[] left = eval(equation.split("=")[0]), right = eval(equation.split("=")[1]);
        left[0] -= right[0];
        left[1] = right[1] - left[1];
        if (left[0] == 0 && left[1] == 0) {
            return "Infinite solutions";
        } else if (left[0] == 0) {
            return "No solution";
        } else {
            return "x="+left[1]/left[0];
        }
    }

    private int[] eval(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2];
        for (String token: tokens) {
            System.out.print(token+" ");
            if (token.equals("+x") || token.equals("x")) {
                res[0]++;
            } else if (token.equals("-x")) {
                res[0]--;
            } else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                res[1] += Integer.parseInt(token);
            }
        }
        System.out.println();
        return res;
    }
}
