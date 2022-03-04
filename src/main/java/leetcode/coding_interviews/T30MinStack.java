package leetcode.coding_interviews;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author wangbo
 * @since 2022年03月04日 10:36
 */
public class T30MinStack {

    @Test
    public void test() {
        // MinStack minStack = new MinStack();
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }


    /**
     * yu-nie-szw解答
     * 另起一个栈（或者随便一个啥）保存当前栈中最小的元素。 因为栈的出栈入栈顺序是固定的，
     * 每次出入都是栈顶的元素，所以另起的栈跟原来栈同步出入，另起的栈栈顶元素就是当前栈中最小元素。
     */
    class MinStack {

        private Deque<Integer> stack = new ArrayDeque<>();
        private Deque<Integer> min = new ArrayDeque<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);

            Integer pre = min.peek();
            if (pre == null) min.push(x);
            else min.push(Math.min(pre, x));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }

    /**
     * Krahets解答
     * 辅助栈存储的数据更少
     */
    class MinStack2 {
        Stack<Integer> A, B;

        public MinStack2() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            // A.push(x);
            // B.isEmpty();
            A.add(x);
            if (B.empty() || B.peek() >= x)
                B.add(x);
        }

        public void pop() {
            if (A.pop().equals(B.peek()))
                B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}
