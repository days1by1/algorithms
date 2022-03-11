package leetcode.coding_interviews;

import java.util.*;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月10日 10:42
 */
public class T35CopyRandomList {

    /**
     * 我的解答
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head, newHead = new Node(head.val), newCur = newHead;
        Map<Node, Integer> orderMap = new HashMap<>();
        List<Node> order = new LinkedList<>();
        List<Node> newOrder = new LinkedList<>();
        int index = 0;
        orderMap.put(cur, index++);
        order.add(cur);
        newOrder.add(newCur);

        while (cur.next != null) {
            cur = cur.next;
            newCur.next = new Node(cur.val);
            newCur = newCur.next;
            orderMap.put(cur, index++);
            order.add(cur);
            newOrder.add(newCur);
        }
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).random != null) {
                newOrder.get(i).random = newOrder.get(orderMap.get(order.get(i).random));
            }
        }

        return newHead;
    }

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
