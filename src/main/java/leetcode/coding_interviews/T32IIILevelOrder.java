package leetcode.coding_interviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月06日 11:09
 */
public class T32IIILevelOrder {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        levelOrder(root).forEach(System.out::println);
        levelOrder2(root).forEach(System.out::println);
        levelOrder3(root).forEach(System.out::println);
        levelOrder4(root).forEach(System.out::println);
    }

    /**
     * 我的解答：双栈思路
     * 最初自己想的是队列+栈，但搞不出来。看到评论区姚不凡说双栈思路，豁然开朗。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 存储奇数层
        Stack<TreeNode> oddStack = new Stack<>();
        // 存储偶数层
        Stack<TreeNode> evenStack = new Stack<>();
        if (root != null) oddStack.add(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            if (!oddStack.isEmpty()) {
                int size = oddStack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = oddStack.pop();
                    temp.add(node.val);
                    if (node.left != null) evenStack.add(node.left);
                    if (node.right != null) evenStack.add(node.right);
                }
            } else {
                int size = evenStack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = evenStack.pop();
                    temp.add(node.val);
                    if (node.right != null) oddStack.add(node.right);
                    if (node.left != null) oddStack.add(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * Krahets解答：双端队列。
     * 把链表LinkedList作为双端队列使用
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if ((res.size() & 1) == 0) tmp.addLast(node.val);
                else tmp.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * Krahets解答：双端队列（奇偶层逻辑分离）
     * 使用双端队列Deque，奇偶层逻辑分离减少冗余判断
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // 打印奇数层
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if (deque.isEmpty()) break;  // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) deque.addFirst(node.right);
                if (node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * Krahets解答：倒序
     */
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
