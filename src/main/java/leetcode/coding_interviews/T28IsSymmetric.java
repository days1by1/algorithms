package leetcode.coding_interviews;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 难度：简单
 * 可能是下午脑子有点懵，简单题都没做出来orz
 *
 * @author wangbo
 * @since 2022年03月03日 13:45
 */
public class T28IsSymmetric {

    /**
     * Krahets解答
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);

    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
