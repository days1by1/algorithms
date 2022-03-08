package leetcode.coding_interviews;

import org.junit.Test;

import java.util.Stack;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月07日 13:31
 */
public class T33VerifyPostorder {

    @Test
    public void test() {
        // 题目给的条件是二叉搜索树，只是看是否是后序遍历序列，
        // 因此划分左右子树的方法是从左找第一个大于根节点的节点
        System.out.println(verifyPostorder(new int[]{4, 3, 2}));    // 看作是没有左子树
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        System.out.println(verifyPostorder2(new int[]{1, 3, 2, 6, 5}));
    }

    /**
     * Krahets解答：递归分治
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    /**
     * Krahets参考「失火的夏天」的解答：辅助单调栈
     */
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
