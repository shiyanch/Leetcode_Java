package SimplifyPath;

import java.util.Stack;

/**
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Test Cases:
 * "/"
 * ""
 * "/../../.././../"
 * "/../.././../home/..///./../"
 * "a/b/c/../c/../../d/"
 */


public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        Stack<String> stack = new Stack<>();
        for(String p:paths) {
            if(p.equals(".") || p.equals(""))
                continue;

            if(p.equals("..")) {
                if(stack.size()>0)
                    stack.pop();
                continue;
            }

            stack.push(p);
        }

        if(stack.isEmpty())
            return "/";

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, "/"+stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../.././../home/..///./../"));
    }
}
