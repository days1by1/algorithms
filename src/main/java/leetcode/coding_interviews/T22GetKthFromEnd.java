package leetcode.coding_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author wangbo
 * @since 2022年02月27日 12:25
 */
public class T22GetKthFromEnd {

    /**
     * 我的解答1（时间优先）：把链表转换成List
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (k <= list.size()) {
            return list.get(list.size() - k);
        }
        return null;
    }

    /**
     * 我的解答2（空间优先）：先遍历一次获得链表长度，再第二次遍历获得倒数第k个
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (k <= n) {
            cur = head;
            for (int i = 0; i < n - k; i++) {
                cur = cur.next;
            }
            return cur;
        }
        return null;
    }
}
