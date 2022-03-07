package leetcode.coding_interviews;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月07日 13:31
 */
public class T33VerifyPostorder {

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
        return true;
    }
}
