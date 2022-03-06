package leetcode.coding_interviews;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月06日 9:11
 */
public class T31ValidateStackSequences {

    /**
     * Krahets解答：模拟方法
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
