package leetcode.coding_interviews;

import org.junit.Test;

/**
 * @author wangbo
 * @since 2022年03月25日 16:55
 */
public class T42MaxSubArray {

    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }

    /**
     * ccy1277解答
     */
    public int maxSubArray(int[] nums) {
        // 判断边界
        if (nums == null || nums.length == 0) return 0;
        // 记录当前位置子数组和
        int max = 0;
        // 记录了已扫描区域的最大子数组和，(踩坑)初值不能为零，子数组最大和可能是负数
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // 如果前面子数组的和加上当前位置的数比此数本身还要小，则不用考虑前面子数组和，
            // 直接从当前位置出发
            if (max <= 0) {
                max = nums[i];
            } else {
                max = max + nums[i];
            }
            // 如果当前位置子数组和大于已扫描区域最大子数组和
            if (ans < max) ans = max;
        }
        return ans;
    }

    /**
     * ru-k-h解答，思路同上
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0], curSum = 0;
        for (int num : nums) {
            // 不能写成sum = Math.max(sum, sum + nums[i]);
            // 可以写成curSum = num + Math.max(curSum, 0);
            curSum = curSum <= 0 ? num : curSum + num;
            // 可以写成maxSum = maxSum < sum ? sum : maxSum;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /**
     * Krahets解答，动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray3(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
