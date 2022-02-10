package leetcode.all;

import java.util.Scanner;

/**
 * 2. 两数相加（https://leetcode-cn.com/problems/add-two-numbers/）
 *
 * @author wangbo
 * @since 2021/11/23 15:08
 */
public class T2AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");

        /*ListNode l1 = new ListNode(Integer.parseInt(s1[0]));
        ListNode l2 = new ListNode(Integer.parseInt(s2[0]));
        ListNode temp = l1;
        for (int i = 1; i < s1.length; i++) {
            temp.next = new ListNode(Integer.parseInt(s1[i]));
            temp = temp.next;
        }
        temp = l2;
        for (int i = 1; i < s2.length; i++) {
            temp.next = new ListNode(Integer.parseInt(s2[i]));
            temp = temp.next;
        }*/

        ListNode l1 = arrayToListNode(s1);
        ListNode l2 = arrayToListNode(s2);
        ListNode result = ListNode.addTwoNumbers(l1, l2);

        // 输出
        ListNode node = result;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 数组转ListNode
     */
    private static ListNode arrayToListNode(String[] arr) {
        ListNode result = null;
        ListNode temp = null;
        for (String s : arr) {
            ListNode listNode = new ListNode(Integer.parseInt(s));
            if (result == null) {
                result = listNode;
                temp = listNode;
            } else {
                temp.next = listNode;
                temp = temp.next;
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
