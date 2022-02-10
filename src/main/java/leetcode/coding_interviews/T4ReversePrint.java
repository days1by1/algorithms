package leetcode.coding_interviews;

import java.util.*;

/**
 * @author  wangbo
 * @since   2021/11/30 21:28
 */
public class T4ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode cur = head;
        for (int i = 3; i < 10; i = i + 2) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        int[] print = reversePrint2(head);
        System.out.println(Arrays.toString(print));
    }

    // 评论中的解答：不使用栈
    public static int[] reversePrint2(ListNode head) {
        ListNode temp = head;

        // 方法一：先获取链表长度
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int[] print = new int[length];
        temp = head;
        for (int i = length - 1; i >= 0; i--) {
            print[i] = temp.val;
            temp = temp.next;
        }

        // 方法二：使用ArrayList（ArrayList需要经常扩容，效率较低）
        // List<Integer> list = new ArrayList<>();
        // while (temp != null) {
        //     list.add(temp.val);
        //     temp = temp.next;
        // }
        // // 对list倒序遍历
        // /*int[] print = new int[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     print[i] = list.get(list.size() - 1 - i);
        // }*/
        // // 也可直接将list颠倒
        // Collections.reverse(list);
        // // Integer[] print = (Integer[]) list.toArray();
        // int[] print = list.stream().mapToInt(Integer::intValue).toArray();

        return print;
    }

    // 官方解答
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();    // 由于栈弹出时容量会变化，因此先存起来
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
