package leetcode.coding_interviews;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangbo
 * @since 2021/12/2 21:45
 */
public class T5BuildTree {

    @Test
    public void test() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);

        // List<Integer> preorderList = TreeNode.preorder(root);
        // System.out.println(preorderList);
        // List<Integer> inorderList = TreeNode.inorder(root);
        // System.out.println(inorderList);
        TreeNode.preorderPrintTree(root);
        System.out.println();
        TreeNode.inorderPrintTree(root);
    }

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft,
                                int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int inorderRoot = map.get(preorder[preorderLeft]);
        int sizeOfLeftSubtree = inorderRoot - inorderLeft;
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeOfLeftSubtree,
                inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeOfLeftSubtree + 1, preorderRight,
                inorderRoot + 1, inorderRight);

        return root;
    }
}
