package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * @author wangbo
 * @since 2022年02月14日 13:15
 */
public class T16MyPow {

    @Test
    public void test() {
        System.out.println(myPow(2, 6));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(0.44528, 0));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        /* Java 代码中 int32 变量 n∈[−2147483648,2147483647] ，因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。
         * 解决方法是先将 nn 存入 long 变量 bb ，后面用 bb 操作即可。
         */
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
