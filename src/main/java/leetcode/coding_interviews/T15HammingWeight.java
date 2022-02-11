package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指Offer 15. 二进制中1的个数（汉明重量）
 * 提示：在Java中，没有无符号整数类型，但对结果并没有影响——因为无论整数是有符号的还是无符号的，
 * 其内部的二进制表示形式（补码）都是相同的。
 *
 * @author wangbo
 * @since 2022年02月11日 9:49
 */
public class T15HammingWeight {

    @Test
    public void test() {
        /*
         * Integer.MAX_VALUE = 2^31 - 1 = 2147483647
         * int n = 4294967293;  // 编译报错：超过int范围
         * 4294967293 = (11111111111111111111111111111101)b，在Java中为-3
         */
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight2(-3));
        System.out.println(hammingWeight3(-3));
    }

    /**
     * 官方：采用位与运算循环检查二进制位
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) res++;
        }
        return res;
    }

    /**
     * 官方：位运算优化
     * 观察这个运算：n&(n - 1)，其运算结果恰为把n的二进制位中的最低位的1变为0之后的结果。
     * 如：6&(6-1) = 4, 6 = (110)b, 4 = (100)b，运算结果4即为把6的二进制位中的最低位的1变为0之后的结果。
     * 这样我们可以利用这个位运算的性质加速我们的检查过程。在实际代码中，我们不断让当前的n与n-1做与运算，
     * 直到n变为0即可。因为每次运算会使得n的最低位的1被翻转，因此运算次数就等于n的二进制位中1的个数。
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    /**
     * 评论：调用类库
     */
    public int hammingWeight3(int n){
        return Integer.bitCount(n);
    }
}
