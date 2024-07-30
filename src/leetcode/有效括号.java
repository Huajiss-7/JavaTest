package leetcode;

import java.util.Stack;

public class 有效括号 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {//防止上来全是右括号，或者右括号很多
                return false;
            } else if (c == ')') {
                if (stack.pop() == '(') continue;
                return false;
            } else if (c == ']') {
                if (stack.pop() == '[') continue;
                return false;
            } else if (c == '}') {
                if (stack.pop() == '{') continue;
                return false;
            } else return false;
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
