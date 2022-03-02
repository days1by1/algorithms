package data_structures_and_algorithms.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbo
 * @since 2021/12/7 23:10
 */
public class BinaryTreeDemo {

    @Test
    public void test(){
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BinaryTreeNode root = BinaryTreeNode.buildTree(preorder, inorder);

        BinaryTreeNode.preorderPrintTree(root);
        System.out.println();
        BinaryTreeNode.inorderPrintTree(root);
        System.out.println();

        // int[] preorder2 = new int[]{10, 9, 20, 15, 7};
        // int[] inorder2 = new int[]{9, 10, 15, 20, 7};
        // TreeNode root2 = TreeNode.buildTree(preorder2, inorder2);
        //
        // TreeNode.preorderPrintTree(root2);
        // System.out.println();
        // TreeNode.inorderPrintTree(root2);
        // System.out.println();

        System.out.println("递归前序遍历：" + BinaryTreeNode.preorder(root));
        System.out.println("递归中序遍历：" + BinaryTreeNode.inorder(root));
        System.out.println("递归后序遍历：" + BinaryTreeNode.postorder(root));

        System.out.println("----------");
        System.out.println("非递归前序遍历：" + BinaryTreeNode.preorder2(root));
        System.out.println("非递归中序遍历：" + BinaryTreeNode.inorder2(root));
        System.out.println("非递归后序遍历：" + BinaryTreeNode.postorder2(root));
        // System.out.println("递归层序遍历：" + TreeNode.levelOrder(root));
        // System.out.println("递归层序遍历2：" + TreeNode.levelOrder2(root));
        // System.out.println("递归层序遍历3：" + TreeNode.levelOrder3(root));
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }
}
