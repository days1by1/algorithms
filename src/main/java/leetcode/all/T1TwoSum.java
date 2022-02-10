package leetcode.all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1. 两数之和（https://leetcode-cn.com/problems/two-sum/）
 *
 * @author wangbo
 * @since 2021/11/21 17:03
 */
public class T1TwoSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int target = sc.nextInt();
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        // int[] result = twoSum(nums, target);
        int[] result = twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

    // 暴力枚举
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 哈希表
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
