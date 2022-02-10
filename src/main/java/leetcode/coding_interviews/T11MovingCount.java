package leetcode.coding_interviews;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 注意题目中是从（0，0）出发，所以虽然地图中还有其他可通行的区域，但却不计算其格子数。
 *
 * @author wangbo
 * @since 2022年01月06日 14:58
 */
public class T11MovingCount {

    @Test
    public void test() {
        System.out.println(movingCount(16, 16, 1));
    }


    /**
     * 评论区解答：DFS，需要使用递归
     */
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // 由于索引是从（0，0）递增的，所以不用判断小于0的情况
        if (i >= m || j >= n || get(i) + get(j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    /**
     * 官方解答：BFS，需要使用队列
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
