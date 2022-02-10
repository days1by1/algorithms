package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 10-II：青蛙跳台阶问题
 *
 * @author wangbo
 * @since 2021/12/17 11:48
 */
public class T8NumWays {

    @Test
    public void test() {
        System.out.println(numWays(7));
    }

    public int numWays(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return 1;
        }
        int p = 0, q = 1, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
