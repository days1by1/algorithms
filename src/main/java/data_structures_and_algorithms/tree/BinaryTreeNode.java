package data_structures_and_algorithms.tree;

import util.Maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author  wangbo
 * @since   2021/12/7 21:46
 */
public class BinaryTreeNode {

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    // 递归遍历结果
    private static List<Integer> resultList;
    // 构建二叉树所用哈希表
    private static Map<Integer, Integer> indexMap;

    BinaryTreeNode(int val) {
        this.val = val;
    }

    /**
     * 构建二叉树
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 二叉树根节点
     */
    public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = Maps.newHashMapWithExpectedSize(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private static BinaryTreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft,
                                              int preorderRight, int inorderLeft, int inorderRight) {

        if (preorderLeft > preorderRight) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(preorder[preorderLeft]);
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        int sizeOfLeftSubtree = inorderRoot - inorderLeft;
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1,
                preorderLeft + sizeOfLeftSubtree, inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeOfLeftSubtree + 1,
                preorderRight, inorderRoot + 1, inorderRight);

        return root;
    }

    // 为了避免多次调用递归的遍历方法时，resultList出现累加，
    // 用此方法来新建resultList，以此隔离多个递归遍历方法的结果
    public static List<Integer> preorder(BinaryTreeNode root) {
        resultList = new ArrayList<>();
        return myPreorder(root);
    }

    public static List<Integer> inorder(BinaryTreeNode root) {
        resultList = new ArrayList<>();
        return myInorder(root);
    }

    public static List<Integer> postorder(BinaryTreeNode root) {
        resultList = new ArrayList<>();
        return myPostorder(root);
    }

    /**
     * 前序遍历（递归）
     */
    private static List<Integer> myPreorder(BinaryTreeNode root) {
        if (root == null) {
            return resultList;
        }

        resultList.add(root.val);
        if (root.left != null) {
            myPreorder(root.left);
        }
        if (root.right != null) {
            myPreorder(root.right);
        }

        return resultList;
    }

    /**
     * 中序遍历（递归）
     */
    private static List<Integer> myInorder(BinaryTreeNode root) {
        if (root == null) {
            return resultList;
        }

        if (root.left != null) {
            myInorder(root.left);
        }
        resultList.add(root.val);
        if (root.right != null) {
            myInorder(root.right);
        }

        return resultList;
    }

    /**
     * 后序遍历（递归）
     */
    private static List<Integer> myPostorder(BinaryTreeNode root) {
        if (root == null) {
            return resultList;
        }

        if (root.left != null) {
            myPostorder(root.left);
        }
        if (root.right != null) {
            myPostorder(root.right);
        }
        resultList.add(root.val);

        return resultList;
    }

    /**
     * 前序遍历（非递归)：使用栈
     */
    public static List<Integer> preorder2(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return resultList;
    }


    /**
     * 中序遍历（非递归）
     */
    public static List<Integer> inorder2(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 一直先把左节点依次放入栈中
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BinaryTreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return resultList;
    }

    /**
     * 后序遍历（非递归）：使用两个栈
     */
    public static List<Integer> postorder2(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            resultList.add(stack2.pop().val);
        }

        return resultList;
    }

    /**
     * 后序遍历（非递归）：使用一个栈
     */
    public static List<Integer> postorder3(BinaryTreeNode root) {
        return null;
    }

    /**
     * 层序遍历
     */
    public static List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(temp);
        }

        return resultList;
    }

    public static List<Integer> levelOrder2(BinaryTreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            resultList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return resultList;
    }

    public static List<Integer> levelOrder3(BinaryTreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        List<BinaryTreeNode> list = new ArrayList<>();
        if (root != null) {
            list.add(root);
        }

        int i = 0;
        while (i < list.size()) {
            BinaryTreeNode node = list.get(i);
            resultList.add(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            i++;
        }

        return resultList;
    }

    /**
     * 前序遍历打印二叉树
     */
    public static void preorderPrintTree(BinaryTreeNode root) {
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
     */
    public static void inorderPrintTree(BinaryTreeNode root) {
        if (root.left != null) {
            inorderPrintTree(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            inorderPrintTree(root.right);
        }
    }
}
