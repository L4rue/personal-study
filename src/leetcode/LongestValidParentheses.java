package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        int len = longestValidParentheses("(()()()(");
        System.out.println(len);
    }

    public static int longestValidParentheses(String s) {
        int len = 0, maxlen = 0;
        Stack<Integer> parentheses = new Stack<>();
        Integer[] res = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 所有括号均标记为合法（0）
            res[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            // 右括号 入栈
            if ("(".equals(s1)) {
                parentheses.push(i);
            } else {
                // 左括号，如果栈是空的，则是多余的括号（不合法），标记为1
                if (parentheses.isEmpty()) {
                    res[i] = 1;
                } else {
                    // 栈不为空，则说明有匹配的有括号，将对应的右括号出栈
                    parentheses.pop();
                }
            }
        }
        // 循环结束的时候，栈里剩下的，均为多余的括号，标记为1
        if (!parentheses.isEmpty()) {
            for (Integer integer : parentheses) {
                res[integer] = 1;
            }
        }
        // 将"(()()()("转为了[1,0,0,0,0,0,0,1]
        // 将原问题转为了最长“0”字符串的问题
        for (Integer re : res) {
            if (re == 1) {
                len = 0;
            } else {
                len++;
            }
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}
