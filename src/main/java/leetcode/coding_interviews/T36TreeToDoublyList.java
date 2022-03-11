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
