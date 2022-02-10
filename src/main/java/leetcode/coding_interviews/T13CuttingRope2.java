package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指Offer 14-II. 剪绳子（涉及大数越界情况下的求余问题）
 *
 * @author wangbo
 * @since 2022年02月10日 20:32
 */
public class T13CuttingRope2 {

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(59));

        System.out.println("==== 注意：除以2和右移2位的结果并不相同！！！ ====");
        System.out.println(9 / 2);
        System.out.println(9 >> 2);
    }

    /**
     * 循环求余：基于(xy)%p=[(x%p)(y%p)]%p
     *
     * @param x 底数
     * @param a 幂
     * @param p 要取得模
     * @return x^a % p
     */
    public int loopRemainder(int x, int a, int p) {
        long rem = 1;
        for (int i = 0; i < a; i++) {
            rem = (rem * x) % p;
        }
        return (int)rem;
    }

    /**
     * 快速幂求余：基于(xy)%p=[(x%p)(y%p)]%p
     *
     * @param x 底数
     * @param a 幂
     * @param p 要取得模
     * @return x^a % p
     */
    public int fastPowerRemainder(int x, int a, int p) {
        long rem = 1, X = x;
        while (a > 0) {
            if (a % 2 == 1) rem = (rem * X) % p;
            X = (X * X) % p;
            a /= 2;
            // a >>= 2;    // 此处需要除以2再向下取整，不能使用右移
        }
        return (int)rem;
    }

    /**
     * 数学推导
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;

        // for (int a = n / 3 - 1; a > 0; a /= 2) {
        //     if (a % 2 == 1) rem = (rem * x) % p;
        //     x = (x * x) % p;
        // }
        // rem = loopRemainder((int) x, n / (int) x - 1, p);
        rem = fastPowerRemainder((int) x, n / (int) x - 1, p);

        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }
}
