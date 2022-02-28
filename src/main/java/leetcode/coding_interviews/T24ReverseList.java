package leetcode.coding_interviews;

import java.util.Stack;

/**
 * 简单
 * 剑指 Offer 24. 反转链表
 *
 * @author wangbo
 * @since 2022年02月28日 8:58
 */
public class T24ReverseList {

    /**
     * 我的解答：使用栈存储链表
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode cur = null;
        if (stack.size() > 0) {
            head = stack.pop();
            cur = head;
        }
        while (stack.size() > 0) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        if (cur != null) cur.next = null;
        return head;
    }
}
