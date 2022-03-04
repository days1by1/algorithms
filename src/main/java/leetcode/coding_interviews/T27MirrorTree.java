package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 难度：简单
 * 知识点：二叉树的递归
 * 一开始不敢做，觉得挺难的，后来一看难度是简单，才大胆地做出来了。还是不要怕困难！！！
 *
 * @author wangbo
 * @since 2022年03月02日 9:03
 */
public class T27MirrorTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        TreeNode cur = root.left;
        cur.left = new TreeNode(1);
        cur.right = new TreeNode(3);
        cur = root.right;
        cur.left = new TreeNode(6);
        cur.right = new TreeNode(9);

        TreeNode.preorderPrintTree(root);
        System.out.println();
        // TreeNode newRoot = mirrorTree(root);
        // TreeNode newRoot = mirrorTree2(root);
        TreeNode newRoot = mirrorTree3(root);
        TreeNode.preorderPrintTree(newRoot);
    }

    /**
     * 我的解答
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        return recur(root, newRoot);
    }

    public TreeNode recur(TreeNode root, TreeNode newRoot) {
        if (root.left != null) {
            newRoot.right = new TreeNode(root.left.val);
            recur(root.left, newRoot.right);
        }
        if (root.right != null) {
            newRoot.left = new TreeNode(root.right.val);
            recur(root.right, newRoot.left);
        }
        return newRoot;
    }

    /**
     * LuoBron解答，容易理解
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        // 从上到下直接交换左右子树
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        mirrorTree2(root.left);
        mirrorTree2(root.right);
        return root;
    }

    /**
     * 官方解答，难理解。
     * 跟着走一遍理解了。
     */
    public TreeNode mirrorTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree3(root.left);
        TreeNode right = mirrorTree3(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
