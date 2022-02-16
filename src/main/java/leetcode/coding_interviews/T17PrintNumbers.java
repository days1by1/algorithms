package leetcode.coding_interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author wangbo
 * @since 2022年02月15日 9:19
 */
public class T17PrintNumbers {

    @Test
    public void test() {
        System.out.println(Arrays.toString(printNumbers(2)));
        System.out.println(Arrays.toString(printNumbers2(2)));
        // System.out.println(printNumbers3(2));
        System.out.println(Arrays.toString(printNumbers4(2)));
    }

    /**
     * 2022-2-15
     * 我的解答
     */
    public int[] printNumbers(int n) {
        int base = 1, max = 0;
        while (n-- > 0) {
            max += base * 9;
            base *= 10;
        }
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 2022-2-15
     * Krahets解答：max = 10^n - 1
     * 例如：99 = 10^2 - 1
     */
    public int[] printNumbers2(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    /**
     * Krahets解答：大数打印解法
     * 1. 表示大数的变量类型：字符串
     * 2. 生成数字的字符串集：递归生成全排列
     */
    // StringBuilder res;
    // int nine = 0, start, n;
    // char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    //
    // public String printNumbers3(int n) {
    //     this.n = n;
    //     res = new StringBuilder();
    //     num = new char[n];
    //     start = n - 1;
    //     dfs(0);
    //     res.deleteCharAt(res.length() - 1);  // 删除最后多余的逗号
    //     return res.toString();
    // }
    //
    // public void dfs(int x) {
    //     if (x == n) {
    //         String s = String.valueOf(num).substring(start);  // 去除高位多余的0
    //         if (!s.equals("0")) res.append(s).append(",");  // 列表从1开始，不添加0
    //         if (n - start == nine) start--;
    //         return;
    //     }
    //     for (char i : loop) {
    //         if (i == '9') nine++;
    //         num[x] = i;
    //         dfs(x + 1);
    //     }
    //     nine--;
    // }

    /**
     * 大数打印解法：返回int数组
     */
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers4(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
