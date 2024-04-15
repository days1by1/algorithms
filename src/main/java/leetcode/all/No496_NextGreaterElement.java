package leetcode.all;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 * 难度：简单
 * 标签：单调栈
 *
 * @author wangbo
 * @created 2024年04月15日 19:18
 */
public class No496_NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        int[] nums3 = {2, 4}, nums4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums3, nums4)));
    }

    // 官方题解：单调栈 + 哈希表
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

}
