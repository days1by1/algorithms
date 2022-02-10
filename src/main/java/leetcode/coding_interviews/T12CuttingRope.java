package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指Offer 14-I. 剪绳子
 * 与主站343题整数拆分（https://leetcode-cn.com/problems/integer-break/）相同
 *
 * @author wangbo
 * @since 2022年01月17日 13:47
 */
public class T12CuttingRope {

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope2(10));
    }

    /**
     * 动态规划——来自主站343题：整数拆分。
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
                dp[i] = curMax;
            }
        }
        return dp[n];
    }

    /**
     * 优化的动态规划——来自主站343题：整数拆分。
     */
    public int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        // 之所以初始化dp[2]，并从dp[3]开始计算，是为了保证循环正确执行
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
