package leetcode.coding_interviews;

/**
 * @author wangbo
 * @since 2021/12/2 21:46
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    /**
     * 前序遍历打印二叉树
     *
     * @param root
     */
    public static void preorderPrintTree(TreeNode root) {
        System.out.print(root.val + " ");
        if (root.left != null) {
            preorderPrintTree(root.left);
        }
        if (root.right != null) {
            preorderPrintTree(root.right);
        }
    }

    /**
     * 中序遍历打印二叉树
     *
     * @param root
     */
    public static void inorderPrintTree(TreeNode root) {
        if (root.left != null) {
            inorderPrintTree(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            inorderPrintTree(root.right);
        }
    }
}
