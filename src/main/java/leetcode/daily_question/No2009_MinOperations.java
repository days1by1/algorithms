package leetcode.daily_question;

import java.util.Arrays;

/**
 * 2009. 使数组连续的最少操作数
 *
 * @author wangbo
 * @created 2024年04月08日 21:33
 */
public class No2009_MinOperations {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(minOperations(new int[]{1, 10, 100, 1000}));
    }


    /**
     * 「灵茶山艾府」题解：正难则反+滑动窗口
     *
     * @see <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/solutions/1005398/on-zuo-fa-by-endlesscheng-l7yi/">「灵茶山艾府」题解</a>
     */
    public static int minOperations(int[] nums) {
        // 排序
        Arrays.sort(nums);

        // 原地去重
        int n = nums.length;
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        // 滑动窗口求最多保留多少个元素
        int ans = 0, left = 0;
        for (int i = 0; i < m; i++) {
            while (nums[left] < nums[i] - n + 1) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }

        // 总数-最多保留的元素个数=最少操作次数
        return n - ans;
    }

}
