package leetcode.coding_interviews;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangbo
 * @since 2021/11/28 11:44
 */
public class T1FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    // 我的解答
    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = -1;
        for (int num : nums) {
            if (arr[num] == num) {
                return num;
            }
            arr[num] = num;
        }
        return -1;
    }

    // 官方解答
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
