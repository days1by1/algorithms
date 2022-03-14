package leetcode.coding_interviews;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月11日 9:29
 */
public class T36TreeToDoublyList {

    /**
     * 我的解答
     */
    List<Node> list = new LinkedList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).right = list.get(i == list.size() - 1 ? 0 : i + 1);
            list.get(i).left = list.get(i == 0 ? list.size() - 1 : i - 1);
        }

        // 减少判断次数
        // if (list.size() > 2) {
        //     for (int i = 1; i < list.size() - 1; i++) {
        //         list.get(i).right = list.get(i + 1);
        //         list.get(i).left = list.get(i - 1);
        //     }
        //     list.get(0).right = list.get(1);
        //     list.get(0).left = list.get(list.size() - 1);
        //     list.get(list.size() - 1).right = list.get(0);
        //     list.get(list.size() - 1).left = list.get(list.size() - 2);
        // } else if (list.size() == 2) {
        //     list.get(0).right = list.get(1);
        //     list.get(0).left = list.get(1);
        //     list.get(1).right = list.get(0);
        //     list.get(1).left = list.get(0);
        // } else if (list.size() == 1) {
        //     list.get(0).right = list.get(0);
        //     list.get(0).left = list.get(0);
        // }


        return list.get(0);
    }

    /**
     * 二叉搜索树中序遍历
     */
    public void inorder(Node root) {
        if (root.left != null) {
            inorder(root.left);
        }
        list.add(root);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    /**
     * Krahets解答
     */
    Node pre, head;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
