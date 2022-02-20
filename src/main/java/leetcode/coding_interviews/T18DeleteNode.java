package leetcode.coding_interviews;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author wangbo
 * @since 2022年02月20日 16:37
 */
public class T18DeleteNode {

    /**
     * 我的解答
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * Krahets解答
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }
}
