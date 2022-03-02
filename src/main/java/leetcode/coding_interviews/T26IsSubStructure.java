package leetcode.coding_interviews;

/**
 * 剑指 Offer 26. 树的子结构
 * 难度：中等
 * 知识点：二叉树的递归
 *
 * @author wangbo
 * @since 2022年02月28日 14:46
 */
public class T26IsSubStructure {

    /**
     * Krahets解答，加上注释
     * 判断树B是否是树A的子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 先序遍历树A，判断树B是否是以树A的任意一个节点为根节点的子树的子结构
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 递归判断树B是否是树A的子结构
     */
    public boolean recur(TreeNode A, TreeNode B) {
        // if (B == null) return true;
        // if (A == null || A.val != B.val) return false;

        // 看评论，如果交换了A和B的判空顺序会出错，可以这样写
        if (A == null && B != null) return false;
        if (A == null) return true;
        if (B == null) return true;
        if (A.val != B.val) return false;

        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
