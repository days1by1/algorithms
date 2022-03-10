package leetcode.coding_interviews;

import java.util.*;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 难度：中等
 *
 * @author wangbo
 * @since 2022年03月09日 9:35
 */
public class T34PathSum {

    /**
     * 官方解答：DFS
     */
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new LinkedList<>(path));
        }
        // 本来想加上这个判断减少遍历的深度，结果发现节点的值可以为负，所以这个是不对的。
        // if (target < 0) {
        //     path.pollLast();
        //     return;
        // }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    /**
     * 官方解答：BFS
     */
    List<List<Integer>> ret = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            Integer rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == target) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> tmp = new LinkedList<>();
        while (node != null) {
            tmp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(tmp);
        ret.add(tmp);
    }
}
