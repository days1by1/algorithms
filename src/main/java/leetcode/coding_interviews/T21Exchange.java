package leetcode.coding_interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author wangbo
 * @since 2022年02月26日 19:11
 */
public class T21Exchange {

    @Test
    public void test() {
        int n = 100000000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        long t1 = System.currentTimeMillis();
        exchange(nums);
        // System.out.println(Arrays.toString(nums));
        long t2 = System.currentTimeMillis();
        exchange2(nums2);
        // System.out.println(Arrays.toString(nums2));
        long t3 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
    }

    /**
     * 我的解答
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && ((nums[j] & 1) == 0)) j--;
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    /**
     * 官方解答：尽量减少循环体内的操作
     */
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && ((nums[j] & 1) == 0)) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

}
