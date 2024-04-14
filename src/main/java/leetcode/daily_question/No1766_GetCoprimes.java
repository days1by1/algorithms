package leetcode.daily_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1766. 互质树
 * 难度：困难
 * 学习了List<Integer>[]、Arrays.setAll()、Arrays.fill()
 *
 * @author wangbo
 * @created 2024年04月13日 21:26
 */
public class No1766_GetCoprimes {

    private static final int MAX = 51;
    private static final int[][] coprime = new int[MAX][MAX];
    private static final int[] valDepth = new int[MAX];
    private static final int[] valNodeId = new int[MAX];

    static {
        // 预处理
        // coprime[i] 保存 [1, MX) 中与 i 互质的所有元素
        for (int i = 1; i < MAX; i++) {
            int k = 0;
            for (int j = 1; j < MAX; j++) {
                if (gcd(i, j) == 1) coprime[i][k++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 2};
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}};
        System.out.println(Arrays.toString(getCoprimes(nums, edges)));
        int[] nums2 = new int[]{5, 6, 10, 2, 3, 6, 15};
        int[][] edges2 = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        System.out.println(Arrays.toString(getCoprimes(nums2, edges2)));
    }

    // 灵茶山艾府题解，理解之后默写，做了些小改动，主要是把valDepth和valNodeId放到类变量上
    @SuppressWarnings("unchecked")
    public static int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;

        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, s -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        dfs(0, -1, 1, nums, ans, graph);

        return ans;
    }


    private static void dfs(int i, int father, int depth, int[] nums, int[] ans, List<Integer>[] graph) {
        // i的节点值
        int val = nums[i];

        // 计算与 val 互质的祖先节点值中，节点深度最大的节点编号
        int maxDepth = 0;
        for (int j : coprime[val]) {
            if (j == 0) break;
            if (valDepth[j] > maxDepth) {
                maxDepth = valDepth[j];
                ans[i] = valNodeId[j];
            }
        }

        // tmpDepth 和 tmpNodeId 用于恢复现场
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];
        // 保存 val 对应的节点深度和节点编号
        valDepth[val] = depth;
        valNodeId[val] = i;
        // 向下递归
        for (int j : graph[i]) {
            if (j != father) {
                dfs(j, i, depth + 1, nums, ans, graph);
            }
        }

        // 恢复现场
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;
    }


    /**
     * 辗转相除法（欧几里得算法）求两个整数a，b的最大公约数（Greatest Common Divisor）
     *
     * @param a 整数a
     * @param b 整数b
     * @return 整数a和b最大公约数
     */
    public static int gcd(int a, int b) {
        // 以下两种写法均可，第二种比第一种多递归一次
        // return a % b == 0 ? b : gcd(b, a % b);
        return b == 0 ? a : gcd(b, a % b);
    }

}
