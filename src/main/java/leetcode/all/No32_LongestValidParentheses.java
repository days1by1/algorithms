package leetcode.all;

import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * @author wangbo
 * @created 2024年04月08日 22:10
 */
public class No32_LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // 记录每一次连续匹配时的索引和长度
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) continue;
                int j = stack.pop();
                if (j - 1 >= 0 && arr[j - 1] != 0) {
                    arr[i] = i - j + 1 + arr[j - 1];
                } else {
                    arr[i] = i - j + 1;
                }
                max = Math.max(max, arr[i]);
            }
        }
        return max;
    }

}
