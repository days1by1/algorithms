package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 10-I：斐波拉契数列
 * 12-16：此题的几种解法（递归、数组、动态规划）刘意在Java基础2015版视频中讲过
 * 李永乐在斐波那契数列视频中也讲过，还有下一题的青蛙跳台阶问题。
 *
 * @author wangbo
 * @since 2021/12/10 15:32
 */
public class T7Fib {

    @Test
    public void test() {
        System.out.println(fib(48));
    }

    // 我的解答
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // 此处注意：应该在每次相加的时候都取模以免结果越界。
            // 报错两次换来的结论，即使用long如果此处不取模结果也会越界
            fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 1000000007;
        }
        return fibArray[n] % 1000000007;
    }

    // 12-16
    // 官方解答1：动态规划
    public int fib2(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
