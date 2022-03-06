package leetcode.coding_interviews;

import org.junit.Test;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月06日 11:09
 */
public class T33IIILevelOrder {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> lists = levelOrder(root);
        lists.forEach(System.out::println);
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
}
