package leetcode.daily_question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2007. 从双倍数组中还原原数组
 * 难度：中等
 *
 * @author wangbo
 * @created 2024年04月18日 21:13
 */
public class No2007_FindOriginalArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6, 3, 0, 1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1})));
    }

    /**
     * 灵茶山艾府题解：排序 + 哈希表
     * 学习了Map.merge()方法
     */
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n == 0 || (n & 1) == 1) return new int[0];

        int[] ans = new int[n >> 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        int ansIdx = 0;
        for (int x : changed) {
            if (!cnt.containsKey(x)) {
                if (ansIdx == ans.length) return new int[0];
                ans[ansIdx++] = x;
                // cnt.put(x << 1, cnt.getOrDefault(x << 1, 0) + 1);
                cnt.merge(x << 1, 1, Integer::sum);
            } else {
                // int c = cnt.put(x, cnt.get(x) - 1);
                int c = cnt.merge(x, -1, Integer::sum);
                if (c == 0) cnt.remove(x);
            }
        }
        return ans;
    }

}
