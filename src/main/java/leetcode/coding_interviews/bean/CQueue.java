package leetcode.coding_interviews.bean;

import java.util.Stack;

/**
 * T5（对应书上09）：用两个栈实现队列
 *
 * @author wangbo
 * @since 2021/12/10 15:01
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    // 我的解答
    /*public int deleteHead() {
        int res = -1;
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            res = stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        return res;
    }*/

    // 官方解答
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
