package leetcode.coding_interviews;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author wangbo
 * @since 2022年02月28日 14:34
 */
public class T25MergeTwoLists {

    /**
     * 我的解答
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, cur;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            head = l2;
            l2 = l2.next;
        } else if (l2 == null) {
            head = l1;
            l1 = l1.next;
        } else if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        cur = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
